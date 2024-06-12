package dev.em_3.simplespectatormode

import org.bukkit.NamespacedKey
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class SimpleSpectatorMode : JavaPlugin(), Listener {

    override fun onEnable() {
        COORDINATES_KEY = NamespacedKey(this, "safe-coordinates")
    }

    companion object {
        lateinit var COORDINATES_KEY: NamespacedKey
    }
}