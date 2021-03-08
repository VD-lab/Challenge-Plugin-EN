package me.aaron.timer.challenges;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomDrops {
    public static HashMap<ItemStack, ItemStack> drops = new HashMap<>();
    public static ArrayList<Material> mats = new ArrayList<>();
    public static ArrayList<Material> available = new ArrayList<>();
    public static boolean allRandom = false;
    public static void start() {
        Random random = new Random();
        if (drops.isEmpty()) {
            Collections.addAll(mats, Material.values());
            mats.remove(Material.AIR);
            mats.add(mats.get(random.nextInt(mats.size())));
            Collections.addAll(available, Material.values());
            available.remove(Material.AIR);
            available.add(available.get(random.nextInt(available.size())));
            for (Material mat : mats) {
                Material mat2 = available.get(random.nextInt(available.size() - 1));
                drops.put(makeToItemStack(mat), makeToItemStack(mat2));

            }
        }
    }

    public static ItemStack makeToItemStack(Material mat) {
        return new ItemStack(mat);
    }
}
