package com.noobnuby.plugin.events

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Join: Listener {
    @EventHandler
    fun PlayerJoinEvent.onJoin() {
        val p = player
        joinMessage(Component.text("${p.name}님이 서버에 접속하셨습니다").color(NamedTextColor.YELLOW))
    }
}