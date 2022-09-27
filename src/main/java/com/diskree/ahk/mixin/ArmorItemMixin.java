package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorItem.class)
public class ArmorItemMixin {

    @Shadow
    @Final
    protected ArmorMaterial type;

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void useInject(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (!AchievementHardcoreMod.isAllowEquipIronArmor && type == ArmorMaterials.IRON) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipIronArmor);
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        } else if (!AchievementHardcoreMod.isAllowEquipDiamondArmor && type == ArmorMaterials.DIAMOND) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipDiamondArmor);
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        } else if (!AchievementHardcoreMod.isAllowEquipNetheriteArmor && type == ArmorMaterials.NETHERITE) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowEquipNetheriteArmor);
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        }
    }
}
