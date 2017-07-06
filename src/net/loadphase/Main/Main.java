package net.loadphase.Main;

import net.loadphase.Listener.CloseChest;
import net.loadphase.Listener.InteractChest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by loadp on 06.07.2017.
 */
public class Main extends JavaPlugin {
    Random rnd;
    public static Main plugin;
    private LotteryManager lotteryManager;
    public static ArrayList<ItemStack> items = new ArrayList();
    public static HashMap<Player, LotteryManager> main = new HashMap<>();
    @Override
    public void onEnable() {
        plugin = this;
        init();
        addItems();
        lotteryManager = new LotteryManager();
    }
    public void init() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InteractChest(), this);
        pm.registerEvents(new CloseChest(), this);
    }

    @Override
    public void onDisable() {

    }
    public static Main getPlugin() {
        return plugin;
    }
    public void addItems() {
        items.add(new ItemStack(Material.BED_BLOCK));
        items.add(new ItemStack(Material.BOOK));
        items.add(new ItemStack(Material.DIAMOND));
        items.add(new ItemStack(Material.BOW));
        items.add(new ItemStack(Material.ANVIL));
        items.add(new ItemStack(Material.ARROW));
        items.add(new ItemStack(Material.REDSTONE_BLOCK));
        items.add(new ItemStack(Material.OBSIDIAN));
        items.add(new ItemStack(Material.BOOK));
        items.add(new ItemStack(Material.GLOWSTONE));
    }
    public LotteryManager getLotteryManager()
    {
        return this.lotteryManager;
    }
}
