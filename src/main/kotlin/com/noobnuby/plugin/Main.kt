package com.noobnuby.plugin

import com.noobnuby.plugin.commands.HelloBrigadier
import com.noobnuby.plugin.events.Join
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object { lateinit var instance: Main }

    override fun onEnable() {
        instance = this

        logger.info("Enable Plugin!")

        HelloBrigadier.registerCommand()

        server.pluginManager.apply {
            registerEvents(Join(),this@Main)
        }
    }
}