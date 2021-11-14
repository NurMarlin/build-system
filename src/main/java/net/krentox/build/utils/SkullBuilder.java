package net.krentox.build.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder {

    /**
     * create skull meta class instance
     */
    private Class<?> skullMetaClass;

    /**
     * create skull instance
     */
    private String url;

    /**
     * create item stack instance
     */
    private ItemStack itemStack;

    /**
     * Create skull builder class
     */
    public SkullBuilder(Skull skull) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        try {
            this.url = skull.url;
            this.skullMetaClass = Class.forName("org.bukkit.craftbukkit." + version + ".inventory.CraftMetaSkull");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Get custom Skull from URL
     *
     * @param displayName target displayName
     * @param lore target lore
     * @return item stack
     */
    public SkullBuilder getSkull(String displayName, String... lore) {
        return getSkull(1, displayName, lore);
    }

    /**
     * Get custom Skull from URL
     *
     * @param amount target amount
     * @param displayName target displayName
     * @param lore target lore
     * @return item stack amount
     */
    public SkullBuilder getSkull(int amount, String displayName, String... lore) {

        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, amount, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        try {
            Field profileField = skullMetaClass.getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, this.getProfile());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        meta.setDisplayName(displayName);
        ArrayList<String> loreA = new ArrayList<>(Arrays.asList(lore));
        meta.setLore(loreA);
        skull.setItemMeta(meta);
        itemStack = skull;
        return this;
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
     * @return GameProfile class
     */
    private GameProfile getProfile() {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        Property property = new Property("textures", this.url);
        profile.getProperties().put("textures", property);
        return profile;
    }

    /**
     * Get ItemStack
     *
     * @return item stack instance
     */
    public ItemStack toItemStack() {
        return this.itemStack;
    }

}
