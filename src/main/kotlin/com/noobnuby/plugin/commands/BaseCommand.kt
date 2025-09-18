package com.noobnuby.plugin.commands

import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class BaseCommand() {
	abstract val description: String
	open val aliases: Collection<String> = emptyList()

	abstract fun create() : LiteralCommandNode<CommandSourceStack>
}