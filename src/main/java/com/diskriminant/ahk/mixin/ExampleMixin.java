package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.ExampleMod;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.village.TradeOfferList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantEntity.class)
public class ExampleMixin {

    @Inject(method = "getOffers", at = @At("HEAD"), cancellable = true)
    private void disableVillagerTrades(CallbackInfoReturnable<TradeOfferList> cir) {
        if (!ExampleMod.allowVillagerTrades) {

            cir.setReturnValue(new TradeOfferList());
        }
    }
}