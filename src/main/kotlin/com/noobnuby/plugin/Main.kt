package com.noobnuby.plugin

import com.noobnuby.plugin.commands.Hello
import com.noobnuby.plugin.events.JoinQuit
import org.bukkit.plugin.java.JavaPlugin
import xyz.icetang.lib.kommand.kommand

class Main : JavaPlugin() {
    companion object { lateinit var instance: Main }

    override fun onEnable() {
        instance = this

        logger.info("Enable Plugin!")

        kommand {
            Hello.register(this)
        }

        server.pluginManager.apply {
            registerEvents(JoinQuit(),this@Main)
        }
    }
}