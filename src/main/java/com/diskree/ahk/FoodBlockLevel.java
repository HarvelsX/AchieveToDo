package com.diskree.ahk;

import net.minecraft.item.FoodComponent;

import java.util.Arrays;
import java.util.List;

import static net.minecraft.item.FoodComponents.*;

public enum FoodBlockLevel {
    LEVEL_5(5, List.of(), 0),
    LEVEL_4(4, Arrays.asList(APPLE, POTATO, GLOW_BERRIES, SWEET_BERRIES, HONEY_BOTTLE, BREAD, COOKIE), 100),
    LEVEL_3(3, Arrays.asList(BEEF, RABBIT, GOLDEN_APPLE, BAKED_POTATO, PUMPKIN_PIE, COOKED_COD, COOKED_SALMON), 250),
    LEVEL_2(2, Arrays.asList(PORKCHOP, MUTTON, CHICKEN), 500),
    LEVEL_1(1, Arrays.asList(COOKED_CHICKEN, COOKED_MUTTON, CHORUS_FRUIT), 750),
    NO_BLOCKING(0, Arrays.asList(COOKED_BEEF, COOKED_PORKCHOP, ENCHANTED_GOLDEN_APPLE, GOLDEN_CARROT), 875);

    private final int level;
    private final List<FoodComponent> foodList;
    private final int achievementsCountToUnlock;

    FoodBlockLevel(int level, List<FoodComponent> foodList, int achievementsCountToUnlock) {
        this.level = level;
        this.foodList = foodList;
        this.achievementsCountToUnlock = achievementsCountToUnlock;
    }

    public int getLevel() {
        return level;
    }

    public List<FoodComponent> getFoodList() {
        return foodList;
    }

    public int getAchievementsCountToUnlock() {
        return achievementsCountToUnlock;
    }
}
