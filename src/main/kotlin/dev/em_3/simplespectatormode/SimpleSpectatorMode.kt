package dev.em_3.simplespectatormode

import org.bukkit.NamespacedKey
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

object SimpleSpectatorMode : JavaPlugin(), Listener {

    lateinit var COORDINATES_KEY: NamespacedKey

    override fun onEnable() {
        COORDINATES_KEY = NamespacedKey(SimpleSpectatorMode, "safe-coordinates")
    }

}