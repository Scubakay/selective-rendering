package com.scubakay.selectiverendering;

import com.scubakay.selectiverendering.event.handler.ModEvents;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectiveRenderingClient implements ClientModInitializer {
    public static final String MOD_ID = "selective-rendering";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // TODO: Move to a hotkey somehow
    public static final boolean SELECTIVE_RENDERING_ENABLED = true;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Selective Rendering");
        ModEvents.registerClientEvents();
    }
}
