package com.diskree.ahk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class AchievementHardcoreMod implements ModInitializer {

    private static final List<FoodComponent> blockedFood = new ArrayList<>();
    private static final EnumMap<BlockedAction, Boolean> blockedActions = new EnumMap<>(BlockedAction.class);
    private static int lastFoodBlockLevel;
    private static int lastAchievementsCount;

    public static void showFoodBlockedDescription(FoodComponent food) {
        if (MinecraftClient.getInstance().player == null) {
            return;
        }
        for (FoodBlockLevel foodBlockLevel : FoodBlockLevel.values()) {
            if (foodBlockLevel.getFoodList().contains(food)) {
                int leftAchievementsCount = foodBlockLevel.getAchievementsCountToUnlock() - lastAchievementsCount;
                MinecraftClient.getInstance().player.sendMessage(Text.of("Эта еда сейчас недоступна. Для разблокировки осталось выполнить достижений: " + leftAchievementsCount).copy().formatted(Formatting.YELLOW), true);
                break;
            }
        }
    }

    public static void setAchievementsCount(int count) {
        if (count == 0 || count < lastAchievementsCount) {
            lastAchievementsCount = 0;
            blockedActions.clear();
            for (BlockedAction action : BlockedAction.values()) {
                blockedActions.put(action, false);
            }
            lastFoodBlockLevel = FoodBlockLevel.LEVEL_5.getLevel();
            blockedFood.clear();
            for (FoodBlockLevel food : FoodBlockLevel.values()) {
                blockedFood.addAll(food.getFoodList());
            }
        }
        if (lastAchievementsCount == count) {
            return;
        }
        lastAchievementsCount = count;
        for (BlockedAction action : BlockedAction.values()) {
            if (count >= action.getAchievementsCountToUnlock()) {
                blockedActions.put(action, true);
            }
        }
        for (FoodBlockLevel food : FoodBlockLevel.values()) {
            if (count >= food.getAchievementsCountToUnlock() && lastFoodBlockLevel > food.getLevel()) {
                lastFoodBlockLevel = food.getLevel();
                blockedFood.removeAll(food.getFoodList());
            }
        }
    }

    public static boolean isActionBlocked(BlockedAction action) {
        Boolean value = blockedActions.get(action);
        if (value != null && value) {
            return false;
        }
        if (MinecraftClient.getInstance().player != null) {
            int leftAchievementsCount = action.getAchievementsCountToUnlock() - lastAchievementsCount;
            MinecraftClient.getInstance().player.sendMessage(Text
                    .of(action.getDescription() + ". Для разблокировки осталось выполнить достижений: " + leftAchievementsCount)
                    .copy()
                    .formatted(Formatting.YELLOW), true
            );
        }
        return true;
    }

    public static boolean isFoodBlocked(FoodComponent food) {
        return lastFoodBlockLevel > 0 && blockedFood.contains(food);
    }

    private boolean isToolBlocked(ItemStack itemStack) {
        if (!itemStack.isDamageable()) {
            return false;
        }
        Item item = itemStack.getItem();
        if (item instanceof ToolItem) {
            ToolMaterial toolMaterial = ((ToolItem) item).getMaterial();
            return toolMaterial == ToolMaterials.IRON && AchievementHardcoreMod.isActionBlocked(BlockedAction.USING_IRON_TOOLS) ||
                    toolMaterial == ToolMaterials.DIAMOND && AchievementHardcoreMod.isActionBlocked(BlockedAction.USING_DIAMOND_TOOLS) ||
                    toolMaterial == ToolMaterials.NETHERITE && AchievementHardcoreMod.isActionBlocked(BlockedAction.USING_NETHERITE_TOOLS);
        }
        return false;
    }

    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world != null && world.getRegistryKey() == World.OVERWORLD && pos != null) {
                if (pos.getY() >= 0 && isActionBlocked(BlockedAction.BREAK_BLOCKS_IN_POSITIVE_Y) || pos.getY() < 0 && isActionBlocked(BlockedAction.BREAK_BLOCKS_IN_NEGATIVE_Y)) {
                    return ActionResult.FAIL;
                }
            }
            if (isToolBlocked(player.getInventory().getMainHandStack())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (isToolBlocked(player.getInventory().getMainHandStack())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack itemStack = player.getInventory().getMainHandStack();
            if (isToolBlocked(itemStack)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
