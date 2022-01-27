package me.char321.sfadvancements.implementation;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.char321.sfadvancements.api.AdvancementBuilder;
import me.char321.sfadvancements.api.AdvancementGroup;
import me.char321.sfadvancements.api.criteria.InteractCriterion;
import me.char321.sfadvancements.api.criteria.InventoryCriterion;
import me.char321.sfadvancements.api.criteria.PlaceCriterion;
import me.char321.sfadvancements.util.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DefaultAdvancements {
    private DefaultAdvancements() {}

    static AdvancementGroup basic = new AdvancementGroup(new CustomItemStack(Material.SLIME_BALL,
            "&fBasic",
            "&7&oThe core spirit of Slimefun."));
    static AdvancementGroup electric = new AdvancementGroup(new CustomItemStack(Material.REDSTONE,
            "&eElectric",
            "&7&oThe center of civilization."));
    static AdvancementGroup testing = new AdvancementGroup(new CustomItemStack(Material.RED_STAINED_GLASS,
            "&4Testing",
            "&7&ohi"));

    public static void registerDefaultAdvancements() {
        new AdvancementBuilder()
                .key(Utils.keyOf("interact"))
                .group(testing)
                .display(new CustomItemStack(Material.CRAFTING_TABLE,
                        "&aGetting Started",
                        "interact with a totem"))
                .name("&a[Getting Started]")
                .criteria(new InteractCriterion(
                        "interact",
                        1,
                        new ItemStack(Material.TOTEM_OF_UNDYING)
                ))
                .register();
        new AdvancementBuilder()
                .key(Utils.keyOf("inventory"))
                .group(testing)
                .display(new CustomItemStack(Material.REDSTONE,
                        "&ainventory",
                        "obtain a energy regulator"))
                .name("&a[Inventory]")
                .criteria(new InventoryCriterion(
                        "inventory",
                        SlimefunItems.ENERGY_REGULATOR
                ))
                .register();
        new AdvancementBuilder()
                .key(Utils.keyOf("build"))
                .group(testing)
                .display(new CustomItemStack(Material.DIRT,
                        "&abuild",
                        "place 100 dirt"))
                .name("&a[Build]")
                .criteria(new PlaceCriterion(
                        "build",
                        100,
                        Material.DIRT
                ))
                .register();
        testing.register();

    }
}
