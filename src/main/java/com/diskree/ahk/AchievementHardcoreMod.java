package com.diskree.ahk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.item.FoodComponents.*;

public class AchievementHardcoreMod implements ModInitializer {

    private static final int countForAllowJump = 10;
    private static final int countForAllowSprint = 15;
    private static final int countForAllowSneak = 20;
    private static final int countForAllowBreakBlocksInPositiveY = 25;
    private static final int countForAllowPlaceBlocks = 30;
    private static final int countForAllowUsingBoat = 40;
    private static final int countForAllowUsingCraftingTable = 50;
    private static final int countForAllowUsingFurnace = 60;
    private static final int countForAllowUsingIronTools = 70;
    private static final int countForAllowUsingShield = 80;
    private static final int countForAllowUsingWaterBucket = 90;
    private static final int countForSetFoodProhibitionLevelTo_4 = 100;
    private static final int countForAllowEquipIronArmor = 110;
    private static final int countForAllowUsingSmoker = 125;
    private static final int countForAllowUsingBlastFurnace = 150;
    private static final int countForAllowUsingAnvil = 175;
    private static final int countForAllowBreakBlocksInNegativeY = 200;
    private static final int countForSetFoodProhibitionLevelTo_3 = 250;
    private static final int countForAllowMoveToNetherDimension = 300;
    private static final int countForAllowUsingDiamondTools = 350;
    private static final int countForAllowEquipDiamondArmor = 400;
    private static final int countForAllowUsingBrewingStand = 450;
    private static final int countForSetFoodProhibitionLevelTo_2 = 500;
    private static final int countForAllowUsingBeacon = 600;
    private static final int countForAllowNetheriteTools = 650;
    private static final int countForAllowEquipNetheriteArmor = 700;
    private static final int countForAllowMoveToEnderDimension = 725;
    private static final int countForSetFoodProhibitionLevelTo_1 = 750;
    private static final int countForAllowEquipElytra = 775;
    private static final int countForAllowTeleportViaEndGate = 800;
    private static final int countForAllowUsingEnderChest = 825;
    private static final int countForAllowUsingShulkerBox = 850;
    private static final int countForSetFoodProhibitionLevelTo_0 = 875;
    private static final int countForAllowUsingFireworksWhileFly = 900;
    private static final int countForAllowTradeWithVillagers = 925;
    private static final int countForAllowUsingEnchantingTable = 950;
    private static final int countForAllowDropTotem = 1000;

    private static int lastAchievementsCount;

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
    public static boolean isAllowEquipIronArmor;
    public static boolean isAllowUsingSmoker;
    public static boolean isAllowUsingBlastFurnace;
    public static boolean isAllowUsingAnvil;
    public static boolean isAllowBreakBlocksInNegativeY;
    public static boolean isAllowMoveToNetherDimension;
    public static boolean isAllowUsingDiamondTools;
    public static boolean isAllowEquipDiamondArmor;
    public static boolean isAllowUsingBrewingStand;
    public static boolean isAllowUsingBeacon;
    public static boolean isAllowNetheriteTools;
    public static boolean isAllowEquipNetheriteArmor;
    public static boolean isAllowMoveToEnderDimension;
    public static boolean isAllowEquipElytra;
    public static boolean isAllowTeleportViaEndGate;
    public static boolean isAllowUsingEnderChest;
    public static boolean isAllowUsingShulkerBox;
    public static boolean isAllowUsingFireworksWhileFly;
    public static boolean isAllowTradeWithVillagers;
    public static boolean isAllowUsingEnchantingTable;
    public static boolean isAllowDropTotem;

    private static int foodProhibitionLevel;
    private static final List<FoodComponent> prohibitionedFood = new ArrayList<>();

    public static void setAchievementsCount(int count) {
        if (count == 0) {
            lastAchievementsCount = 0;
            isAllowJump = false;
            isAllowSprint = false;
            isAllowSneak = false;
            isAllowBreakBlocksInPositiveY = false;
            isAllowPlaceBlocks = false;
            isAllowUsingBoat = false;
            isAllowUsingCraftingTable = false;
            isAllowUsingFurnace = false;
            isAllowUsingIronTools = false;
            isAllowUsingShield = false;
            isAllowUsingWaterBucket = false;
            isAllowEquipIronArmor = false;
            isAllowUsingSmoker = false;
            isAllowUsingBlastFurnace = false;
            isAllowUsingAnvil = false;
            isAllowBreakBlocksInNegativeY = false;
            isAllowMoveToNetherDimension = false;
            isAllowUsingDiamondTools = false;
            isAllowEquipDiamondArmor = false;
            isAllowUsingBrewingStand = false;
            isAllowUsingBeacon = false;
            isAllowNetheriteTools = false;
            isAllowEquipNetheriteArmor = false;
            isAllowMoveToEnderDimension = false;
            isAllowEquipElytra = false;
            isAllowUsingFireworksWhileFly = false;
            isAllowTeleportViaEndGate = false;
            isAllowUsingEnderChest = false;
            isAllowUsingShulkerBox = false;
            isAllowTradeWithVillagers = false;
            isAllowUsingEnchantingTable = false;
            isAllowDropTotem = false;
            foodProhibitionLevel = 5;
            prohibitionedFood.clear();
            prohibitionedFood.addAll(Arrays.asList(
                    APPLE, BAKED_POTATO, BEEF, BREAD, CHICKEN, CHORUS_FRUIT, COOKED_BEEF, COOKED_CHICKEN,
                    COOKED_COD, COOKED_MUTTON, COOKED_PORKCHOP, COOKED_SALMON, COOKIE,
                    ENCHANTED_GOLDEN_APPLE, GOLDEN_APPLE, GOLDEN_CARROT, HONEY_BOTTLE, MUTTON, PORKCHOP, POTATO,
                    PUMPKIN_PIE, RABBIT, SWEET_BERRIES, GLOW_BERRIES
            ));
        }
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
        if (count >= countForAllowEquipIronArmor) {
            isAllowEquipIronArmor = true;
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
                    BEEF, RABBIT, GOLDEN_APPLE, BAKED_POTATO, PUMPKIN_PIE, COOKED_COD, COOKED_SALMON
            ));
        }
        if (count >= countForAllowMoveToNetherDimension) {
            isAllowMoveToNetherDimension = true;
        }
        if (count >= countForAllowUsingDiamondTools) {
            isAllowUsingDiamondTools = true;
        }
        if (count >= countForAllowEquipDiamondArmor) {
            isAllowEquipDiamondArmor = true;
        }
        if (count >= countForAllowUsingBrewingStand) {
            isAllowUsingBrewingStand = true;
        }
        if (count >= countForSetFoodProhibitionLevelTo_2 && foodProhibitionLevel > 2) {
            foodProhibitionLevel = 2;
            prohibitionedFood.removeAll(Arrays.asList(
                    PORKCHOP, MUTTON, CHICKEN
            ));
        }
        if (count >= countForAllowUsingBeacon) {
            isAllowUsingBeacon = true;
        }
        if (count >= countForAllowNetheriteTools) {
            isAllowNetheriteTools = true;
        }
        if (count >= countForAllowEquipNetheriteArmor) {
            isAllowEquipNetheriteArmor = true;
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
        if (count >= countForAllowEquipElytra) {
            isAllowEquipElytra = true;
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

    private boolean needPreventToolUsage(ItemStack itemStack) {
        if (itemStack.isDamageable()) {
            Item item = itemStack.getItem();
            if (item instanceof ToolItem) {
                ToolMaterial toolMaterial = ((ToolItem) item).getMaterial();
                return !AchievementHardcoreMod.isAllowUsingIronTools && toolMaterial == ToolMaterials.IRON ||
                        !AchievementHardcoreMod.isAllowUsingDiamondTools && toolMaterial == ToolMaterials.DIAMOND ||
                        !AchievementHardcoreMod.isAllowNetheriteTools && toolMaterial == ToolMaterials.NETHERITE;
            }
        }
        return false;
    }

    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world != null && world.getRegistryKey() == World.OVERWORLD && pos != null) {
                if (!isAllowBreakBlocksInPositiveY && pos.getY() >= 0 || !isAllowBreakBlocksInNegativeY && pos.getY() < 0) {
                    return ActionResult.FAIL;
                }
            }
            if (needPreventToolUsage(player.getInventory().getMainHandStack())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (needPreventToolUsage(player.getInventory().getMainHandStack())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack itemStack = player.getInventory().getMainHandStack();
            if (needPreventToolUsage(itemStack)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
