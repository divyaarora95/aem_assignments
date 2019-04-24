package com.ttn.blogs.core;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rendision extends WCMUsePojo {
    
    protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private String imagePath;
    private String dimensions;
    private String path;
    
    @Override
    public void activate() throws Exception {
        imagePath = getProperties().get("imagePath", String.class);
        dimensions = getProperties().get("dimension", String.class);
        Rendition rendition;
        Resource resource = getResourceResolver().getResource(imagePath);
        Asset asset = resource.adaptTo(Asset.class);
        rendition = asset.getRendition("cq5dam.thumbnail." + dimensions + ".png");
        if (rendition != null) {
            path = rendition.getPath();
        } else {
            rendition = asset.getRendition("original");
            path = rendition.getPath();
        }
    }
    public String getPath() {
        return path;
    }
}