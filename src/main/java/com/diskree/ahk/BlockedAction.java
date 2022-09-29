package com.diskree.ahk;

public enum BlockedAction {
    JUMP("Вы сейчас не можете прыгать", 10),
    SPRINT("Вы сейчас не можете бегать", 15),
    SNEAK("Вы сейчас не можете красться", 20),
    BREAK_BLOCKS_IN_POSITIVE_Y("Вы сейчас не можете ломать блоки", 25),
    PLACE_BLOCKS("Вы сейчас не можете ставить блоки", 30),
    USING_BOAT("Вы сейчас не можете садиться в лодку", 40),
    USING_CRAFTING_TABLE("Вы сейчас не можете использовать верстак", 50),
    USING_FURNACE("Вы сейчас не можете использовать печь", 60),
    USING_IRON_TOOLS("Вы сейчас не можете использовать железные инструменты", 70),
    USING_SHIELD("Вы сейчас не можете использовать щит", 80),
    USING_WATER_BUCKET("Вы сейчас не можете разливать воду", 90),
    EQUIP_IRON_ARMOR("Вы сейчас не можете одевать железную броню", 110),
    USING_SMOKER("Вы сейчас не можете использовать коптильню", 125),
    USING_BLAST_FURNACE("Вы сейчас не можете использовать плавильную печь", 150),
    USING_ANVIL("Вы сейчас не можете использовать наковальню", 175),
    BREAK_BLOCKS_IN_NEGATIVE_Y("Вы сейчас не можете ломать блоки ниже 0 высоты", 200),
    NETHER("Нижний Мир закрыт", 300),
    USING_DIAMOND_TOOLS("Вы сейчас не можете использовать алмазные инструменты", 350),
    EQUIP_DIAMOND_ARMOR("Вы сейчас не можете одевать алмазную броню", 400),
    USING_BREWING_STAND("Вы сейчас не можете использовать зельеварку", 450),
    USING_BEACON("Вы сейчас не можете использовать маяк", 600),
    USING_NETHERITE_TOOLS("Вы сейчас не можете использовать незеритовые инструменты", 650),
    EQUIP_NETHERITE_ARMOR("Вы сейчас не можете одевать незеритовую броню", 700),
    END("Край закрыт", 725),
    EQUIP_ELYTRA("Вы сейчас не можете одевать элитры", 775),
    END_GATE("Этот портал в данный момент недоступен", 800),
    USING_ENDER_CHEST("Вы сейчас не можете использовать эндер-сундук", 825),
    USING_SHULKER_BOX("Вы сейчас не можете использовать шалкеровый ящик", 850),
    USING_FIREWORKS_WHILE_FLY("Вы сейчас не можете использовать фейерверки для полёта", 900),
    TRADE_WITH_VILLAGER("Торговля с деревенскими жителями недоступна", 925),
    USING_ENCHANTING_TABLE("Вы сейчас не можете использовать стол зачарований", 950),
    DROP_TOTEM("Тотем бессмертия недоступен", 1000);

    private final String description;
    private final int achievementsCountToUnlock;

    BlockedAction(String description, int achievementsCountToUnlock) {
        this.description = description;
        this.achievementsCountToUnlock = achievementsCountToUnlock;
    }

    public String getDescription() {
        return description;
    }

    public int getAchievementsCountToUnlock() {
        return achievementsCountToUnlock;
    }
}
