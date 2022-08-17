package com.diskriminant.ahk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.ActionResult;

public class ExampleMod implements ModInitializer {
    public static boolean allowEnchantingTable;
    public static boolean allowVillagerTrades;
    public static boolean allowTotemDrop;

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockEntity blockEntity = world.getBlockEntity(hitResult.getBlockPos());
            if (!allowEnchantingTable && blockEntity != null && blockEntity.getType() == BlockEntityType.ENCHANTING_TABLE) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (pos != null && pos.getY() < 0) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
