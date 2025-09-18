package com.noobnuby.plugin

import com.noobnuby.plugin.commands.BaseCommand
import com.noobnuby.plugin.commands.HelloBrigadier
import com.noobnuby.plugin.events.Join
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object { lateinit var instance: Main }

    override fun onEnable() {
        instance = this

        logger.info("Enable Plugin!")

		val commands = listOf<BaseCommand>(
			HelloBrigadier()
		)

		val listeners = listOf<Listener>(
			Join(),
		)

		commands.forEach { command ->
			this.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { commands ->
				commands.registrar().register(command.create(), command.description, command.aliases)
			}
		}

		listeners.forEach {
			server.pluginManager.registerEvents(it, this)
		}
    }
}