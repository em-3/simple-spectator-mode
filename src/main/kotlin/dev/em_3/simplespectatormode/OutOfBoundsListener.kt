package dev.em_3.simplespectatormode

import com.jeff_media.morepersistentdatatypes.DataType
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class OutOfBoundsListener : Listener {

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val player = event.player

        //Ignore non-tracked players
        if(player.gameMode != GameMode.SPECTATOR || !player.persistentDataContainer.has(SimpleSpectatorMode.COORDINATES_KEY, DataType.LOCATION)) return

        val coordinates = player.persistentDataContainer.get(SimpleSpectatorMode.COORDINATES_KEY, DataType.LOCATION)!!

        //Check if the player has strayed over 35 blocks from their initial position
        if(player.location.distance(coordinates) > 35) {
            //Reset the player back to their original position
            player.teleport(coordinates)
        }
    }

}