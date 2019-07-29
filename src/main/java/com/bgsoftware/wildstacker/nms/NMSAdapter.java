package com.bgsoftware.wildstacker.nms;

import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface NMSAdapter {

    Object getNBTTagCompound(LivingEntity livingEntity);

    void setNBTTagCompound(LivingEntity livingEntity, Object _nbtTagCompound);

    boolean isInLove(Entity entity);

    void setInLove(Entity entity, Player breeder, boolean inLove);

    List<ItemStack> getEquipment(LivingEntity livingEntity);

    List<Entity> getNearbyEntities(LivingEntity livingEntity, int range, Predicate<? super Entity> predicate);

    @Nullable
    String serialize(ItemStack itemStack);

    @Nullable
    ItemStack deserialize(String serialized);

    default Object getChatMessage(String message){
        return message;
    }

    ItemStack setTag(ItemStack itemStack, String key, Object value);

    <T> T getTag(ItemStack itemStack, String key, Class<T> valueType);

    int getEntityExp(LivingEntity livingEntity);

    void updateLastDamageTime(LivingEntity livingEntity);

    void setHealthDirectly(LivingEntity livingEntity, double health);

    //Random getWorldRandom(World world);

    int getNBTInteger(Object nbtTag);

    int getEggLayTime(Chicken chicken);

    Stream<BlockState> getTileEntities(Chunk chunk, Predicate<BlockState> condition);

}
