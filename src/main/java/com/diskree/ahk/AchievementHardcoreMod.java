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
import java.util.Arrays;
import java.util.List;

import static net.minecraft.item.FoodComponents.*;

public class AchievementHardcoreMod implements ModInitializer {

    public static final int countForAllowJump = 10;
    public static final int countForAllowSprint = 15;
    public static final int countForAllowSneak = 20;
    public static final int countForAllowBreakBlocksInPositiveY = 25;
    public static final int countForAllowPlaceBlocks = 30;
    public static final int countForAllowUsingBoat = 40;
    public static final int countForAllowUsingCraftingTable = 50;
    public static final int countForAllowUsingFurnace = 60;
    public static final int countForAllowUsingIronTools = 70;
    public static final int countForAllowUsingShield = 80;
    public static final int countForAllowUsingWaterBucket = 90;
    public static final int countForSetFoodProhibitionLevelTo_4 = 100;
    public static final int countForAllowEquipIronArmor = 110;
    public static final int countForAllowUsingSmoker = 125;
    public static final int countForAllowUsingBlastFurnace = 150;
    public static final int countForAllowUsingAnvil = 175;
    public static final int countForAllowBreakBlocksInNegativeY = 200;
    public static final int countForSetFoodProhibitionLevelTo_3 = 250;
    public static final int countForAllowMoveToNetherDimension = 300;
    public static final int countForAllowUsingDiamondTools = 350;
    public static final int countForAllowEquipDiamondArmor = 400;
    public static final int countForAllowUsingBrewingStand = 450;
    public static final int countForSetFoodProhibitionLevelTo_2 = 500;
    public static final int countForAllowUsingBeacon = 600;
    public static final int countForAllowNetheriteTools = 650;
    public static final int countForAllowEquipNetheriteArmor = 700;
    public static final int countForAllowMoveToEnderDimension = 725;
    public static final int countForSetFoodProhibitionLevelTo_1 = 750;
    public static final int countForAllowEquipElytra = 775;
    public static final int countForAllowTeleportViaEndGate = 800;
    public static final int countForAllowUsingEnderChest = 825;
    public static final int countForAllowUsingShulkerBox = 850;
    public static final int countForSetFoodProhibitionLevelTo_0 = 875;
    public static final int countForAllowUsingFireworksWhileFly = 900;
    public static final int countForAllowTradeWithVillagers = 925;
    public static final int countForAllowUsingEnchantingTable = 950;
    public static final int countForAllowDropTotem = 1000;

    public static int lastAchievementsCount;

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
    private static final List<FoodComponent> prohibitionedFood_4 = new ArrayList<>(Arrays.asList(APPLE, POTATO, GLOW_BERRIES, SWEET_BERRIES, HONEY_BOTTLE, BREAD, COOKIE));
    private static final List<FoodComponent> prohibitionedFood_3 = new ArrayList<>(Arrays.asList(BEEF, RABBIT, GOLDEN_APPLE, BAKED_POTATO, PUMPKIN_PIE, COOKED_COD, COOKED_SALMON));
    private static final List<FoodComponent> prohibitionedFood_2 = new ArrayList<>(Arrays.asList(PORKCHOP, MUTTON, CHICKEN));
    private static final List<FoodComponent> prohibitionedFood_1 = new ArrayList<>(Arrays.asList(COOKED_CHICKEN, COOKED_MUTTON, CHORUS_FRUIT));
    private static final List<FoodComponent> prohibitionedFood_0 = new ArrayList<>(Arrays.asList(COOKED_BEEF, COOKED_PORKCHOP, ENCHANTED_GOLDEN_APPLE, GOLDEN_CARROT));


    public static void showPreventUsage(int neededAchievementsCount) {
        if (MinecraftClient.getInstance().player == null) {
            return;
        }
        MinecraftClient.getInstance().player.sendMessage(Text.of("Сейчас недоступно. Осталось получить достижений: " + (neededAchievementsCount - AchievementHardcoreMod.lastAchievementsCount)).copy().formatted(Formatting.YELLOW), true);
    }

    public static void showPreventFoodUsage(FoodComponent food) {
        if (MinecraftClient.getInstance().player == null) {
            return;
        }
        int count;
        if (prohibitionedFood_4.contains(food)) {
            count = countForSetFoodProhibitionLevelTo_4;
        } else if (prohibitionedFood_3.contains(food)) {
            count = countForSetFoodProhibitionLevelTo_3;
        } else if (prohibitionedFood_2.contains(food)) {
            count = countForSetFoodProhibitionLevelTo_2;
        } else if (prohibitionedFood_1.contains(food)) {
            count = countForSetFoodProhibitionLevelTo_1;
        } else {
            count = countForSetFoodProhibitionLevelTo_0;
        }
        MinecraftClient.getInstance().player.sendMessage(Text.of("Сейчас недоступно. Осталось получить достижений: " + count).copy().formatted(Formatting.YELLOW), true);
    }

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
            prohibitionedFood.addAll(prohibitionedFood_4);
            prohibitionedFood.addAll(prohibitionedFood_3);
            prohibitionedFood.addAll(prohibitionedFood_2);
            prohibitionedFood.addAll(prohibitionedFood_1);
            prohibitionedFood.addAll(prohibitionedFood_0);
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
            prohibitionedFood.removeAll(prohibitionedFood_4);
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
            prohibitionedFood.addAll(prohibitionedFood_3);
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
            prohibitionedFood.removeAll(prohibitionedFood_2);
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
            prohibitionedFood.removeAll(prohibitionedFood_1);
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
            prohibitionedFood.removeAll(prohibitionedFood_0);
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
