package com.scubakay.selectiverendering.util;

import com.scubakay.selectiverendering.SelectiveRenderingClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

public class Selection {
    private static BlockPos lookingAt;
    private BlockPos position1;
    private BlockPos position2;

    public void setPosition(boolean rightClick) {
        updateLookingAt(MinecraftClient.getInstance());
        if (!rightClick) {
            position1 = lookingAt;
            SelectiveRenderingClient.LOGGER.info("Setting position 1: {}", position1.toString());
        } else {
            position2 = lookingAt;
            SelectiveRenderingClient.LOGGER.info("Setting position 2: {}", position2.toString());
        }
    }

    public boolean isValid() {
        return position1 != null && position2 != null;
    }

    public void clearSelection() {
        this.position1 = null;
        this.position2 = null;
    }

    /**
     * LookingAt needs to be updated every tick to get a position for pos1 and pos2
     */
    public static void updateLookingAt(MinecraftClient client) {
        if (client.crosshairTarget != null && client.crosshairTarget instanceof BlockHitResult target) {
            lookingAt = target.getBlockPos();
        } else {
            lookingAt = null;
        }
    }
}
