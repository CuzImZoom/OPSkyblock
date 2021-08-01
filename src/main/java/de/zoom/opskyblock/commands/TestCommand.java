package de.zoom.opskyblock.commands;

import de.zoom.opskyblock.guis.TestGUI;
import me.lucko.helper.command.AbstractCommand;
import me.lucko.helper.command.CommandInterruptException;
import me.lucko.helper.command.context.CommandContext;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class TestCommand extends AbstractCommand {
  @Override
  public void call(@Nonnull CommandContext<?> context) throws CommandInterruptException {
    if(context.sender() instanceof Player) {
      TestGUI.open((Player) context.sender());
    }
  }
}
