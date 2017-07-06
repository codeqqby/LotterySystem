package net.loadphase.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by loadp on 06.07.2017.
 */
public class LotteryManager extends Runnables{
    int rounds;
    int speed = 10;
    int speed_delay;
    Player p;
    Inventory inv;
    private static int taskid;
    List<ItemStack> itemsCommon = new LinkedList<>();

    public void method(Player p) {
        Main.main.put(p, this);
        this.rounds = 65;
        this.p = p;
        Collections.shuffle(Main.items);
        Collections.shuffle(Main.items);
        createInv(p);
        this.start();

    }

    @Override
    public void start() {
        taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (Main.main.containsKey(LotteryManager.this.p)) {
                    int start = 10;
                    int stop = 16;
                    if (LotteryManager.this.rounds != 0) {
                        if (LotteryManager.this.speed_delay == 0) {
                            LotteryManager.this.rounds -= 1;
                            if (LotteryManager.this.speed == 10) {
                                if (LotteryManager.this.rounds == 64) {
                                    LotteryManager.this.speed = 8;
                                }
                                LotteryManager.this.speed_delay = 0;
                            } else if (LotteryManager.this.speed == 8) {
                                if (LotteryManager.this.rounds == 45) {
                                    LotteryManager.this.speed = 6;
                                }
                            } else if (LotteryManager.this.speed == 6) {
                                if (LotteryManager.this.rounds == 36) {
                                    LotteryManager.this.speed = 4;
                                }
                                LotteryManager.this.speed_delay = 1;
                            } else if (LotteryManager.this.speed == 4) {
                                if (LotteryManager.this.rounds == 24) {
                                    LotteryManager.this.speed = 2;
                                }
                                LotteryManager.this.speed_delay = 2;
                            } else if (LotteryManager.this.speed == 2) {
                                if (LotteryManager.this.rounds == 12) {
                                    LotteryManager.this.speed = 0;
                                }
                                LotteryManager.this.speed_delay = 3;
                            } else if (LotteryManager.this.speed == 0) {
                                LotteryManager.this.speed_delay = 3;
                            } else if (LotteryManager.this.speed_delay == 3) {
                                LotteryManager.this.speed = 0;
                            }
                            ItemStack item = Main.items.get(0);
                            Main.items.remove(item);
                            Main.items.add(item);

                            for (ItemStack stack1 : Main.items) {
                                if (start <= stop) {
                                    LotteryManager.this.inv.setItem(start, stack1);
                                    start++;
                                }
                            }
                        } else {
                            LotteryManager.this.speed_delay--;
                        }
                    } else {
                        Bukkit.getScheduler().cancelTask(taskid);
                        ItemStack enditem = LotteryManager.this.inv.getItem(13);
                        for (int i = 0; i < 27; i++) {
                            LotteryManager.this.inv.setItem(i, new ItemStack(Material.AIR));
                        }
                        Main.main.remove(p);
                        LotteryManager.this.inv.setItem(13, enditem);
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        LotteryManager.this.rounds = 50;
                        LotteryManager.this.speed = 10;
                    }
                } else {
                    Bukkit.getScheduler().cancelTask(taskid);
                }
            }

        }, 0L, 2L);
    }

    @Override
    public void stop() {
    }
    public void createInv(Player p) {
        this.inv = Bukkit.createInventory(null, 27, "Lotterie");
        this.inv.setItem(10, null);this.inv.setItem(11, null);this.inv.setItem(12, null);
        this.inv.setItem(13, null);this.inv.setItem(14, null);this.inv.setItem(15, null);
        this.inv.setItem(16, null);
                p.openInventory(this.inv);
            }
    }
