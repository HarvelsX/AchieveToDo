package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "getPreferredEquipmentSlot", at = @At("HEAD"), cancellable = true)
    private static void getPreferredEquipmentSlotInject(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
        if (stack.getHolder() == null) {
            if (!AchievementHardcoreMod.isAllowEquipElytra && stack.isOf(Items.ELYTRA)) {
                AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipElytra);
                cir.setReturnValue(EquipmentSlot.MAINHAND);
            } else {
                Item item = stack.getItem();
                if (item instanceof ArmorItem) {
                    ArmorMaterial armorMaterial = ((ArmorItem) item).getMaterial();
                    if (!AchievementHardcoreMod.isAllowEquipIronArmor && armorMaterial == ArmorMaterials.IRON) {
                        AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipIronArmor);
                        cir.setReturnValue(EquipmentSlot.MAINHAND);
                    } else if (!AchievementHardcoreMod.isAllowEquipDiamondArmor && armorMaterial == ArmorMaterials.DIAMOND) {
                        AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipDiamondArmor);
                        cir.setReturnValue(EquipmentSlot.MAINHAND);
                    } else if (!AchievementHardcoreMod.isAllowEquipNetheriteArmor && armorMaterial == ArmorMaterials.NETHERITE) {
                        AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipNetheriteArmor);
                        cir.setReturnValue(EquipmentSlot.MAINHAND);
                    }
                }
            }
        }
    }
}
