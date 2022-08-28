package com.diskriminant.ahk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.FoodComponent;
import net.minecraft.util.ActionResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.item.FoodComponents.*;

public class AchievementHardcoreMod implements ModInitializer {

    private static int lastAchievementsCount;

    private static int countForAllowJump = 10;
    private static int countForAllowSprint = 15;
    private static int countForAllowSneak = 20;
    private static int countForAllowBreakBlocksInPositiveY = 25;
    private static int countForAllowPlaceBlocks = 30;
    private static int countForAllowUsingBoat = 40;
    private static int countForAllowUsingCraftingTable = 50;
    private static int countForAllowUsingFurnace = 60;
    private static int countForAllowUsingIronTools = 70;
    private static int countForAllowUsingShield = 80;
    private static int countForAllowUsingWaterBucket = 90;
    private static int countForSetFoodProhibitionLevelTo_4 = 100;
    private static int countForAllowDressIronArmor = 110;
    private static int countForAllowUsingSmoker = 125;
    private static int countForAllowUsingBlastFurnace = 150;
    private static int countForAllowUsingAnvil = 175;
    private static int countForAllowBreakBlocksInNegativeY = 200;
    private static int countForSetFoodProhibitionLevelTo_3 = 250;
    private static int countForAllowMoveToNetherDimension = 300;
    private static int countForAllowUsingDiamondTools = 350;
    private static int countForAllowDressDiamondArmor = 400;
    private static int countForAllowUsingBrewingStand = 450;
    private static int countForSetFoodProhibitionLevelTo_2 = 500;
    private static int countForAllowUsingBeacon = 600;
    private static int countForAllowNetheriteTools = 650;
    private static int countForAllowDressNetheriteArmor = 700;
    private static int countForAllowMoveToEnderDimension = 725;
    private static int countForSetFoodProhibitionLevelTo_1 = 750;
    private static int countForAllowDressElytra = 775;
    private static int countForAllowUsingFireworksWhileFly = 800;
    private static int countForAllowTeleportViaEndGate = 825;
    private static int countForAllowUsingEnderChest = 850;
    private static int countForAllowUsingShulkerBox = 875;
    private static int countForSetFoodProhibitionLevelTo_0 = 900;
    private static int countForAllowTradeWithVillagers = 925;
    private static int countForAllowUsingEnchantingTable = 950;
    private static int countForAllowDropTotem = 1000;

    public static boolean isAllowJump;
    public static boolean isAllowSprint;
    public static boolean isAllowSneak;
    public static boolean isAllowBreakBlocksInPositiveY;
    public static boolean isAllowPlaceBlocks;
    public static boolean isAllowUsingBoat;
    public static boolean isAllowUsingCraftingTable;
    public static boolean isAllowUsingFurnace;
    public static boolean isAllowUsingIronTools;
    public static boolean isAllowUsingShield;
    public static boolean isAllowUsingWaterBucket;
    public static boolean isAllowDressIronArmor;
    public static boolean isAllowUsingSmoker;
    public static boolean isAllowUsingBlastFurnace;
    public static boolean isAllowUsingAnvil;
    public static boolean isAllowBreakBlocksInNegativeY;
    public static boolean isAllowMoveToNetherDimension;
    public static boolean isAllowUsingDiamondTools;
    public static boolean isAllowDressDiamondArmor;
    public static boolean isAllowUsingBrewingStand;
    public static boolean isAllowUsingBeacon;
    public static boolean isAllowNetheriteTools;
    public static boolean isAllowDressNetheriteArmor;
    public static boolean isAllowMoveToEnderDimension;
    public static boolean isAllowDressElytra;
    public static boolean isAllowUsingFireworksWhileFly;
    public static boolean isAllowTeleportViaEndGate;
    public static boolean isAllowUsingEnderChest;
    public static boolean isAllowUsingShulkerBox;
    public static boolean isAllowTradeWithVillagers;
    public static boolean isAllowUsingEnchantingTable;
    public static boolean isAllowDropTotem;

    private static final List<FoodComponent> prohibitionedFood = new ArrayList<>(Arrays.asList(
            APPLE, BAKED_POTATO, BEEF, BREAD, CARROT, CHICKEN, CHORUS_FRUIT, COOKED_BEEF, COOKED_CHICKEN, COOKED_COD,
            COOKED_MUTTON, COOKED_PORKCHOP, COOKED_RABBIT, COOKED_SALMON, COOKIE, ENCHANTED_GOLDEN_APPLE, GOLDEN_APPLE,
            GOLDEN_CARROT, HONEY_BOTTLE, MUTTON, PORKCHOP, POTATO, PUMPKIN_PIE, RABBIT, SWEET_BERRIES, GLOW_BERRIES
    ));
    private static int foodProhibitionLevel = 5;

    public static void setAchievementsCount(int count) {
        if (lastAchievementsCount == count) {
            return;
        }
        lastAchievementsCount = count;
        if (count >= countForAllowJump) {
            isAllowJump = true;
        }
        if (count >= countForAllowSprint) {
            isAllowSprint = true;
        }
        if (count >= countForAllowSneak) {
            isAllowSneak = true;
        }
        if (count >= countForAllowBreakBlocksInPositiveY) {
            isAllowBreakBlocksInPositiveY = true;
        }
        if (count >= countForAllowPlaceBlocks) {
            isAllowPlaceBlocks = true;
        }
        if (count >= countForAllowUsingBoat) {
            isAllowUsingBoat = true;
        }
        if (count >= countForAllowUsingCraftingTable) {
            isAllowUsingCraftingTable = true;
        }
        if (count >= countForAllowUsingFurnace) {
            isAllowUsingFurnace = true;
        }
        if (count >= countForAllowUsingIronTools) {
            isAllowUsingIronTools = true;
        }
        if (count >= countForAllowUsingShield) {
            isAllowUsingShield = true;
        }
        if (count >= countForAllowUsingWaterBucket) {
            isAllowUsingWaterBucket = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_4 && foodProhibitionLevel > 4) {
            foodProhibitionLevel = 4;
            prohibitionedFood.removeAll(Arrays.asList(
                    APPLE, POTATO, GLOW_BERRIES, SWEET_BERRIES, HONEY_BOTTLE, BREAD, COOKIE
            ));
        }
        if (count >= countForAllowDressIronArmor) {
            isAllowDressIronArmor = true;
        }
        if (count >= countForAllowUsingSmoker) {
            isAllowUsingSmoker = true;
        }
        if (count >= countForAllowUsingBlastFurnace) {
            isAllowUsingBlastFurnace = true;
        }
        if (count >= countForAllowUsingAnvil) {
            isAllowUsingAnvil = true;
        }
        if (count >= countForAllowBreakBlocksInNegativeY) {
            isAllowBreakBlocksInNegativeY = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_3 && foodProhibitionLevel > 3) {
            foodProhibitionLevel = 3;
            prohibitionedFood.addAll(Arrays.asList(
                    BEEF, RABBIT, CARROT, GOLDEN_APPLE, BAKED_POTATO, PUMPKIN_PIE, COOKED_COD, COOKED_SALMON
            ));
        }
        if (count >= countForAllowMoveToNetherDimension) {
            isAllowMoveToNetherDimension = true;
        }
        if (count >= countForAllowUsingDiamondTools) {
            isAllowUsingDiamondTools = true;
        }
        if (count >= countForAllowDressDiamondArmor) {
            isAllowDressDiamondArmor = true;
        }
        if (count >= countForAllowUsingBrewingStand) {
            isAllowUsingBrewingStand = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_2 && foodProhibitionLevel > 2) {
            foodProhibitionLevel = 2;
            prohibitionedFood.removeAll(Arrays.asList(
                    PORKCHOP, MUTTON, CHICKEN, COOKED_RABBIT
            ));
        }
        if (count >= countForAllowUsingBeacon) {
            isAllowUsingBeacon = true;
        }
        if (count >= countForAllowNetheriteTools) {
            isAllowNetheriteTools = true;
        }
        if (count >= countForAllowDressNetheriteArmor) {
            isAllowDressNetheriteArmor = true;
        }
        if (count >= countForAllowMoveToEnderDimension) {
            isAllowMoveToEnderDimension = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_1 && foodProhibitionLevel > 1) {
            foodProhibitionLevel = 1;
            prohibitionedFood.removeAll(Arrays.asList(
                    COOKED_CHICKEN, COOKED_MUTTON, CHORUS_FRUIT
            ));
        }
        if (count >= countForAllowDressElytra) {
            isAllowDressElytra = true;
        }
        if (count >= countForAllowUsingFireworksWhileFly) {
            isAllowUsingFireworksWhileFly = true;
        }
        if (count >= countForAllowTeleportViaEndGate) {
            isAllowTeleportViaEndGate = true;
        }
        if (count >= countForAllowUsingEnderChest) {
            isAllowUsingEnderChest = true;
        }
        if (count >= countForAllowUsingShulkerBox) {
            isAllowUsingShulkerBox = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_0 && foodProhibitionLevel > 0) {
            foodProhibitionLevel = 0;
            prohibitionedFood.clear();
        }
        if (count >= countForAllowTradeWithVillagers) {
            isAllowTradeWithVillagers = true;
        }
        if (count >= countForAllowUsingEnchantingTable) {
            isAllowUsingEnchantingTable = true;
        }
        if (count >= countForAllowDropTotem) {
            isAllowDropTotem = true;
        }
    }

    public static boolean isProhibitionedFood(FoodComponent food) {
        return foodProhibitionLevel > 0 && prohibitionedFood.contains(food);
    }

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockEntity blockEntity = world.getBlockEntity(hitResult.getBlockPos());
            if (!isAllowUsingEnchantingTable && blockEntity != null && blockEntity.getType() == BlockEntityType.ENCHANTING_TABLE) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!isAllowBreakBlocksInPositiveY && pos != null && pos.getY() < 0) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
