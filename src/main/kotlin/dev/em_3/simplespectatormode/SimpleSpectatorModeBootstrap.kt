package dev.em_3.simplespectatormode

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents

@Suppress("UnstableApiUsage")
class SimpleSpectatorModeBootstrap : PluginBootstrap {

    override fun bootstrap(context: BootstrapContext) {
        val manager = context.lifecycleManager
        manager.registerEventHandler(LifecycleEvents.COMMANDS, CommandEventHandler())
    }

}