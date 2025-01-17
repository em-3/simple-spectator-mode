package dev.em_3.simplespectatormode

import com.jeff_media.morepersistentdatatypes.DataType
import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent
import org.bukkit.GameMode
import org.bukkit.entity.Player

@Suppress("UnstableApiUsage")
class CommandEventHandler : LifecycleEventHandler<ReloadableRegistrarEvent<Commands>> {

    override fun run(event: ReloadableRegistrarEvent<Commands>) {
        val commands = event.registrar()
        commands.register(
            Commands.literal("sp")
                .executes {
                    val player = it.source.executor
                    if (player !is Player) {
                        //Can only switch players to spectator mode
                        it.source.sender.sendMessage("Only players can run this command")
                        return@executes 0
                    }

                    if (player.gameMode == GameMode.SPECTATOR) {
                        if (!player.persistentDataContainer.has(
                                SimpleSpectatorMode.COORDINATES_KEY,
                                DataType.LOCATION
                            )
                        ) {
                            //The player set their gamemode by other means, just switch them back to survival
                            player.gameMode = GameMode.SURVIVAL

                            return@executes Command.SINGLE_SUCCESS
                        }

                        //Retrieve the player's coordinates. The non-null assertion operator is safe in this case, as it is already confirmed the player has their coordinates set
                        val coordinates =
                            player.persistentDataContainer.get(SimpleSpectatorMode.COORDINATES_KEY, DataType.LOCATION)!!

                        //Set the player to their stored coordinates and switch them back to survival
                        player.teleport(coordinates)
                        player.gameMode = GameMode.SURVIVAL

                        player.persistentDataContainer.remove(SimpleSpectatorMode.COORDINATES_KEY)
                    } else if (player.gameMode == GameMode.SURVIVAL) {
                        //Store the player's coordinates and switch them to spectator mode
                        player.persistentDataContainer.set(
                            SimpleSpectatorMode.COORDINATES_KEY,
                            DataType.LOCATION,
                            player.location
                        )

                        player.gameMode = GameMode.SPECTATOR
                    } else {
                        it.source.sender.sendMessage("Target must be in spectator or survival mode")
                        return@executes 0
                    }

                    Command.SINGLE_SUCCESS
                }
                .build(),
            "Switches the user to spectator mode"
        )
    }

}