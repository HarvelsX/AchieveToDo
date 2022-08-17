package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    public void disableTotem(ItemStack itemStack, float yOffset, CallbackInfoReturnable<ItemEntity> cir) {
        if (!ExampleMod.allowTotemDrop && itemStack != null && itemStack.getItem() == Items.TOTEM_OF_UNDYING) {
            cir.setReturnValue(null);
        }
    }
}
