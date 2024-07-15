package com.noobnuby.plugin.commands

import xyz.icetang.lib.icemmand.PluginIcemmand

object Hello {
    fun register(icemmand: PluginIcemmand) {
        icemmand.register("hello") {
            executes {
                sender.sendMessage("Hello, world!")
            }
        }
    }
}