package com.diskree.ahk;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public enum BlockedAction {
    EAT_SALMON(null, FoodComponents.SALMON, 2),
    EAT_COD(null, FoodComponents.COD, 3),
    EAT_TROPICAL_FISH(null, FoodComponents.TROPICAL_FISH, 4),
    EAT_ROTTEN_FLESH(null, FoodComponents.ROTTEN_FLESH, 6),
    JUMP("Вы сейчас не можете прыгать", null, 7),
    EAT_SPIDER_EYE(null, FoodComponents.SPIDER_EYE, 8),
    SPRINT("Вы сейчас не можете бегать", null, 10),
    EAT_CHICKEN(null, FoodComponents.CHICKEN, 14),
    EAT_POISONOUS_POTATO(null, FoodComponents.POISONOUS_POTATO, 16),
    EAT_SUSPICIOUS_STEW(null, FoodComponents.SUSPICIOUS_STEW, 19),
    EAT_MUTTON(null, FoodComponents.MUTTON, 22),
    EAT_RABBIT(null, FoodComponents.RABBIT, 24),
    BREAK_BLOCKS_IN_POSITIVE_Y("Вы сейчас не можете ломать блоки", null, 25),
    EAT_SWEET_BERRIES(null, FoodComponents.SWEET_BERRIES, 27),
    EAT_PORKCHOP(null, FoodComponents.PORKCHOP, 29),
    EAT_BEETROOT(null, FoodComponents.BEETROOT, 37),
    USING_BOAT("Вы сейчас не можете садиться в лодку", null, 40),
    EAT_BEETROOT_SOUP(null, FoodComponents.BEETROOT_SOUP, 45),
    USING_CRAFTING_TABLE("Вы сейчас не можете использовать верстак", null, 50),
    EAT_CARROT(null, FoodComponents.CARROT, 52),
    EAT_APPLE(null, FoodComponents.APPLE, 55),
    EAT_POTATO(null, FoodComponents.POTATO, 58),
    USING_FURNACE("Вы сейчас не можете использовать печь", null, 60),
    EAT_DRIED_KELP(null, FoodComponents.DRIED_KELP, 62),
    EAT_MELON_SLICE(null, FoodComponents.MELON_SLICE, 64),
    USING_IRON_TOOLS("Вы сейчас не можете использовать железные инструменты", null, 70),
    EAT_COOKIE(null, FoodComponents.COOKIE, 72),
    EAT_HONEY_BOTTLE(null, FoodComponents.HONEY_BOTTLE, 77),
    USING_SHIELD("Вы сейчас не можете использовать щит", null, 80),
    EAT_BEEF(null, FoodComponents.BEEF, 83),
    USING_WATER_BUCKET("Вы сейчас не можете разливать воду", null, 90),
    EAT_BREAD(null, FoodComponents.BREAD, 100),
    EAT_RABBIT_STEW(null, FoodComponents.RABBIT_STEW, 105),
    EQUIP_IRON_ARMOR("Вы сейчас не можете одевать железную броню", null, 110),
    EAT_MUSHROOM_STEW(null, FoodComponents.MUSHROOM_STEW, 111),
    USING_SMOKER("Вы сейчас не можете использовать коптильню", null, 125),
    EAT_PUMPKIN_PIE(null, FoodComponents.PUMPKIN_PIE, 145),
    USING_BLAST_FURNACE("Вы сейчас не можете использовать плавильную печь", null, 150),
    USING_ANVIL("Вы сейчас не можете использовать наковальню", null, 175),
    EAT_COOKED_SALMON(null, FoodComponents.COOKED_SALMON, 190),
    EAT_COOKED_COD(null, FoodComponents.COOKED_COD, 195),
    BREAK_BLOCKS_IN_NEGATIVE_Y("Вы сейчас не можете ломать блоки ниже 0 высоты", null, 200),
    EAT_GLOW_BERRIES(null, FoodComponents.GLOW_BERRIES, 240),
    NETHER("Нижний Мир закрыт", null, 300),
    EAT_GOLDEN_APPLE(null, FoodComponents.GOLDEN_APPLE, 333),
    USING_DIAMOND_TOOLS("Вы сейчас не можете использовать алмазные инструменты", null, 350),
    EAT_BAKED_POTATO(null, FoodComponents.BAKED_POTATO, 370),
    EQUIP_DIAMOND_ARMOR("Вы сейчас не можете одевать алмазную броню", null, 400),
    EAT_COOKED_RABBIT(null, FoodComponents.COOKED_RABBIT, 420),
    USING_BREWING_STAND("Вы сейчас не можете использовать зельеварку", null, 450),
    EAT_PUFFERFISH(null, FoodComponents.PUFFERFISH, 455),
    EAT_COOKED_CHICKEN(null, FoodComponents.COOKED_CHICKEN, 500),
    EAT_COOKED_MUTTON(null, FoodComponents.COOKED_MUTTON, 525),
    USING_BEACON("Вы сейчас не можете использовать маяк", null, 600),
    EAT_COOKED_PORKCHOP(null, FoodComponents.COOKED_PORKCHOP, 635),
    USING_NETHERITE_TOOLS("Вы сейчас не можете использовать незеритовые инструменты", null, 650),
    EAT_COOKED_BEEF(null, FoodComponents.COOKED_BEEF, 675),
    EQUIP_NETHERITE_ARMOR("Вы сейчас не можете одевать незеритовую броню", null, 700),
    END("Край закрыт", null, 725),
    EAT_CHORUS_FRUIT(null, FoodComponents.CHORUS_FRUIT, 740),
    EQUIP_ELYTRA("Вы сейчас не можете одевать элитры", null, 775),
    EAT_ENCHANTED_GOLDEN_APPLE(null, FoodComponents.ENCHANTED_GOLDEN_APPLE, 777),
    END_GATE("Этот портал в данный момент недоступен", null, 800),
    USING_ENDER_CHEST("Вы сейчас не можете использовать эндер-сундук", null, 825),
    USING_SHULKER_BOX("Вы сейчас не можете использовать шалкеровый ящик", null, 850),
    EAT_GOLDEN_CARROT(null, FoodComponents.GOLDEN_CARROT, 888),
    USING_FIREWORKS_WHILE_FLY("Вы сейчас не можете использовать фейерверки для полёта", null, 900),
    TRADE_WITH_VILLAGER("Торговля с деревенскими жителями недоступна", null, 925),
    USING_ENCHANTING_TABLE("Вы сейчас не можете использовать стол зачарований", null, 950),
    DROP_TOTEM("Тотем бессмертия недоступен", null, 1000);

    private final String description;
    private final FoodComponent foodComponent;
    private final int achievementsCountToUnlock;

    BlockedAction(String description, FoodComponent foodComponent, int achievementsCountToUnlock) {
        this.description = description;
        this.foodComponent = foodComponent;
        this.achievementsCountToUnlock = achievementsCountToUnlock;
    }

    public String getDescription() {
        return description;
    }

    public FoodComponent getFoodComponent() {
        return foodComponent;
    }

    public int getAchievementsCountToUnlock() {
        return achievementsCountToUnlock;
    }
}
