package com.scubakay.selectiverendering.mixin;

import com.scubakay.selectiverendering.SelectiveRenderingClient;
import com.scubakay.selectiverendering.util.SelectiveRendering;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
    private void onLeftClickMouse(CallbackInfoReturnable<Boolean> cir) {
        if (SelectiveRenderingClient.SELECTIVE_RENDERING_ENABLED) {
            SelectiveRendering.SELECTION.setPosition(false);
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "doItemUse", at = @At("HEAD"), cancellable = true)
    private void onRightClickMouse(CallbackInfo ci)
    {
        if (SelectiveRenderingClient.SELECTIVE_RENDERING_ENABLED) {
            SelectiveRendering.SELECTION.setPosition(true);
            ci.cancel();
        }
    }
}
