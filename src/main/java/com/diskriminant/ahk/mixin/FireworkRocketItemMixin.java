package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.AchievementHardcoreMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void useInject(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (!AchievementHardcoreMod.isAllowUsingFireworksWhileFly && user.isFallFlying()) {
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        }
    }
}
