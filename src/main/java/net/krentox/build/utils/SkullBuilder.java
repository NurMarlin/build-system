package net.krentox.build.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder {

    private static Class<?> skullMetaClass;
    private static Class<?> tileEntityClass;
    private static Class<?> blockPositionClass;
    private static int mcVersion;

    static {
        String version = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        mcVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""));
        try {
            skullMetaClass = Class.forName("org.bukkit.craftbukkit." + version + ".inventory.CraftMetaSkull");
            tileEntityClass = Class.forName("net.minecraft.server." + version + ".TileEntitySkull");
            if (mcVersion > 174) {
                blockPositionClass = Class.forName("net.minecraft.server." + version + ".BlockPosition");
            } else {
                blockPositionClass = null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get custom Skull from URL
     *
     * @param skinURL target url
     * @param displayName target displayName
     * @param lore target lore
     * @return item stack
     */
    public ItemStack getSkull(String skinURL, String displayName, String... lore) {
        return getSkull(skinURL, 1, displayName, lore);
    }

    /**
     * Get custom Skull from URL
     *
     * @param skinURL target url
     * @param amount target amount
     * @param displayName target displayName
     * @param lore target lore
     * @return item stack amount
     */
    public ItemStack getSkull(String skinURL, int amount, String displayName, String... lore) {
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, amount, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        try {
            Field profileField = skullMetaClass.getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, this.getProfile(skinURL));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        meta.setDisplayName(displayName);
        ArrayList<String> loreA = new ArrayList<>(Arrays.asList(lore));
        meta.setLore(loreA);
        skull.setItemMeta(meta);
        return skull;
    }

    /**
     * Change amount from items stack
     *
     * @param itemStack target item stack
     * @param amount target amount
     * @return ItemStack class
     */
    public ItemStack modifyAmount(ItemStack itemStack, int amount) {
        itemStack.setAmount(amount);
        return itemStack;
    }

    /**
     * Get GameProfile from skin url
     *
     * @param skinURL target url
     * @return GameProfile class
     */
    private GameProfile getProfile(String skinURL) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        Property property = new Property("textures", skinURL);
        profile.getProperties().put("textures", property);
        return profile;
    }
}
