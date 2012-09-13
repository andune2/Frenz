package com.live.macsephi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

/** I believe this whole class exists only to provide "enchanting discounts"
 * as described in the original change requests. As such, I think this whole
 * class should probably be removed. Maybe scan through it and see if you
 * see anything of value in here and either trim out what you don't want or
 * delete the class entirely if you don't want any of it.
 * 
 * @author andune
 *
 */
public class RecipeHandler implements Listener {
    private final Server server;

    public RecipeHandler() {
        handleRecipes();
        this.server = Bukkit.getServer();
    }

    private void handleRecipes() {
        ShapelessRecipe r = new ShapelessRecipe(new ItemStack(
                Material.DEAD_BUSH));
        r.addIngredient(Material.LONG_GRASS, 1).addIngredient(
                Material.getMaterial(368));
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.SMOOTH_BRICK, 1, (short)2));
        r.addIngredient(Material.WOOD_AXE, 50).addIngredient(
                Material.SMOOTH_BRICK);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.WOOD_AXE, 4, (short)50));
        r.addIngredient(Material.WOOD_AXE);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.FLINT, 5));
        r.addIngredient(Material.IRON_INGOT);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.MELON_SEEDS));
        r.addIngredient(Material.SEEDS).addIngredient(Material.PUMPKIN_SEEDS);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.RECORD_10));
        r.addIngredient(Material.GREEN_RECORD).addIngredient(Material.RECORD_5);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.SNOW_BLOCK));
        r.addIngredient(Material.SNOW_BALL).addIngredient(Material.SNOW_BALL)
                .addIngredient(Material.SNOW_BALL);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.WATER_LILY));
        r.addIngredient(Material.VINE).addIngredient(Material.VINE)
                .addIngredient(Material.VINE);
        this.server.addRecipe(r);

        r = new ShapelessRecipe(new ItemStack(Material.INK_SACK, 1, (short)3));
        r.addIngredient(Material.SUGAR).addIngredient(Material.DIRT)
                .addIngredient(Material.SUGAR);
        this.server.addRecipe(r);

        FurnaceRecipe f = new FurnaceRecipe(
                new ItemStack(Material.NETHER_BRICK), Material.NETHERRACK);
        this.server.addRecipe(f);

        f = new FurnaceRecipe(new ItemStack(Material.DRAGON_EGG),
                Material.ENDER_PORTAL);
        this.server.addRecipe(f);

        f = new FurnaceRecipe(new ItemStack(36), Material.DRAGON_EGG);
        this.server.addRecipe(f);

        f = new FurnaceRecipe(new ItemStack(Material.RECORD_11, 3),
                Material.SPONGE);
        this.server.addRecipe(f);

        ShapedRecipe s = new ShapedRecipe(new ItemStack(Material.GRASS, 3));
        s.setIngredient('S', Material.SEEDS);
        s.setIngredient('D', Material.DIRT);
        s.shape(new String[] { "SSS", "DDD" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.BEDROCK));
        s.setIngredient('S', Material.MOB_SPAWNER);
        s.setIngredient('G', Material.GOLD_BLOCK);
        s.setIngredient('D', Material.DIAMOND_BLOCK);
        s.shape(new String[] { "DGD", "GSG", "DGD" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.DRAGON_EGG));
        s.setIngredient('X', Material.ENDER_PORTAL);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.STATIONARY_WATER, 2));
        s.setIngredient('W', Material.WATER_BUCKET);
        s.setIngredient('E', Material.EYE_OF_ENDER);
        s.shape(new String[] { " E ", "EWE", " E " });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.STATIONARY_LAVA, 2));
        s.setIngredient('L', Material.LAVA_BUCKET);
        s.setIngredient('E', Material.EYE_OF_ENDER);
        s.shape(new String[] { " E ", "ELE", " E " });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.LAVA));
        s.setIngredient('X', Material.BLAZE_ROD);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.WATER));
        s.setIngredient('X', Material.ICE);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.SPONGE, 3));
        s.setIngredient('W', Material.WOOL, 4);
        s.setIngredient('F', Material.FIRE);
        s.shape(new String[] { "WWW", "WFW", "WWW" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.SMOOTH_BRICK, 8, (short)3));
        s.setIngredient('B', Material.SMOOTH_BRICK, 2);
        s.setIngredient('D', Material.DIAMOND);
        s.shape(new String[] { "BBB", "BDB", "BBB" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.WEB));
        s.setIngredient('X', Material.STRING);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.MOSSY_COBBLESTONE, 3));
        s.setIngredient('V', Material.VINE);
        s.setIngredient('C', Material.COBBLESTONE);
        s.setIngredient('G', Material.GRASS);
        s.shape(new String[] { "VVV", "CCC", "GGG" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.FIRE));
        s.setIngredient('X', Material.LAVA);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.MOB_SPAWNER));
        s.setIngredient('F', Material.FIRE);
        s.setIngredient('X', Material.IRON_FENCE);
        s.setIngredient('I', Material.BLAZE_ROD);
        s.shape(new String[] { "IXI", "XFX", "IXI" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.BURNING_FURNACE));
        s.setIngredient('L', Material.LAVA);
        s.setIngredient('C', Material.COBBLESTONE);
        s.shape(new String[] { "CCC", "CLC", "CCC" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.REDSTONE_ORE));
        s.setIngredient('X', Material.REDSTONE);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.REDSTONE_TORCH_OFF));
        s.setIngredient('T', Material.REDSTONE_TORCH_ON);
        s.setIngredient('B', Material.REDSTONE_ORE);
        s.shape(new String[] { "BBB", "BTB", "BBB" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.ICE, 3));
        s.setIngredient('S', Material.SNOW);
        s.setIngredient('C', Material.CLAY_BRICK);
        s.setIngredient('B', Material.SNOW_BLOCK);
        s.shape(new String[] { "SSS", "CCC", "BBB" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.PORTAL));
        s.setIngredient('B', Material.BEDROCK);
        s.setIngredient('D', Material.DIAMOND_BLOCK);
        s.shape(new String[] { "BDB", "DBD", "BDB" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.MONSTER_EGGS, 32));
        s.setIngredient('S', Material.STONE);
        s.setIngredient('M', Material.MOB_SPAWNER);
        s.shape(new String[] { "SSS", "SMS", "SSS" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.SMOOTH_BRICK, 3, (short)1));
        s.setIngredient('V', Material.VINE);
        s.setIngredient('S', Material.SMOOTH_BRICK);
        s.setIngredient('G', Material.GRASS);
        s.shape(new String[] { "VVV", "SSS", "GGG" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.MYCEL, 3));
        s.setIngredient('R', Material.RED_MUSHROOM);
        s.setIngredient('B', Material.BROWN_MUSHROOM);
        s.setIngredient('G', Material.GRASS);
        s.shape(new String[] { "RRR", "BBB", "GGG" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.ENDER_PORTAL));
        s.setIngredient('X', Material.PORTAL);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.ENDER_PORTAL_FRAME));
        s.setIngredient('B', Material.BEDROCK);
        s.setIngredient('D', Material.DIAMOND);
        s.setIngredient('E', Material.ENDER_STONE);
        s.shape(new String[] { "DBD", "EDE", "EEE" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.ENDER_STONE));
        s.setIngredient('X', Material.SANDSTONE);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.APPLE, 5));
        s.setIngredient('X', Material.SEEDS);
        s.setIngredient('S', Material.SAPLING);
        s.setIngredient('M', Material.MELON_SEEDS);
        s.shape(new String[] { "XXX", "SMS", "XXX" });
        this.server.addRecipe(s);

        s = new ShapedRecipe(new ItemStack(Material.SADDLE));
        s.setIngredient('X', Material.LEATHER);
        s.shape(new String[] { "XXX", "XXX", "XXX" });
        this.server.addRecipe(s);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFurnace(FurnaceBurnEvent event) {
        if ((event.getBlock().getState() instanceof Furnace)) {
            Furnace furnace = (Furnace) event.getBlock().getState();

            switch (furnace.getInventory().getSmelting().getTypeId()) {
            case 87:
                furnace.setCookTime((short)5);
                break;
            case 119:
                furnace.setCookTime((short)14400);
                break;
            case 122:
                furnace.setCookTime((short)32767);
                break;
            case 19:
                furnace.setCookTime((short)30);
            }
        }
    }
}