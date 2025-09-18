package com.noobnuby.plugin.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands
import net.kyori.adventure.text.Component.text
import org.bukkit.entity.Player

class HelloBrigadier: BaseCommand() {
	override val description = "send to player hello message"
	override val aliases: Collection<String> = listOf("hb") // Optional

	override fun create(): LiteralCommandNode<CommandSourceStack> {
		return Commands.literal("hello-brigadier")
			.requires { it.sender.isOp }
			.executes {
				val ctx = it.source.sender
				if(ctx !is Player) return@executes Command.SINGLE_SUCCESS
				ctx.sendMessage(text("Hello, world!"))
				Command.SINGLE_SUCCESS
			}.build()
	}
}