package com.scubakay.selectiverendering.util;

import com.scubakay.selectiverendering.SelectiveRenderingClient;

public class SelectiveRendering {
    public static Selection SELECTION = new Selection();

    public void addSelectionToList() {
        if (!SELECTION.isValid()) {
            SelectiveRenderingClient.LOGGER.info("Selection was not valid");
        }
    }

}
