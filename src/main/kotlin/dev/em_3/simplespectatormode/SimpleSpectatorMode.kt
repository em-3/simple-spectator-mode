package dev.em_3.simplespectatormode

import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin

class SimpleSpectatorMode : JavaPlugin() {

    override fun onEnable() {
        COORDINATES_KEY = NamespacedKey(this, "safe-coordinates")

        server.pluginManager.registerEvents(OutOfBoundsListener(), this)
    }

    companion object {
        lateinit var COORDINATES_KEY: NamespacedKey
    }
}