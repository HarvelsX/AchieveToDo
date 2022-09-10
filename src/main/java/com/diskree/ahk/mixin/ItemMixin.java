package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "getMaxUseTime", at = @At("HEAD"), cancellable = true)
    private void getMaxUseTimeInject(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        if (stack != null && stack.getItem() != null && stack.getItem().isFood() && AchievementHardcoreMod.isProhibitionedFood(stack.getItem().getFoodComponent())) {
            cir.setReturnValue(9);
        }
    }

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void finishUsingInject(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (stack != null && stack.getItem() != null && stack.getItem().isFood() && AchievementHardcoreMod.isProhibitionedFood(stack.getItem().getFoodComponent())) {
            MinecraftClient.getInstance().options.useKey.setPressed(false);
            cir.setReturnValue(stack);
        }
    }
}
