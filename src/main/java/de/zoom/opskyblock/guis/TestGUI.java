package de.zoom.opskyblock.guis;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TestGUI extends Gui {
  private TestGUI(Player player) {
    super(player, 4, "&f&lTest GUI supports colors as title");
  }

  public static void open(Player player) {
    new TestGUI(player);
  }

  @Override
  public void redraw() {
    setItem(1, ItemStackBuilder.of(Material.BOOK).name("&aA cool book.").build(() -> {
      getPlayer().sendMessage("&aYou clicked a book!");
    }));
  }
}
