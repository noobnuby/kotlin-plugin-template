package com.noobnuby.plugin.commands

import net.kyori.adventure.text.Component.text
import xyz.icetang.lib.icemmand.PluginIcemmand

object Hello {
    fun register(icemmand: PluginIcemmand) {
        icemmand.register("hello") {
            executes {
                sender.sendMessage(text("Hello, world!"))
            }
        }
    }
}