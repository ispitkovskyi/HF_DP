package headfirst.proxy.virtualproxyIS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by igors on 01.04.16.
 */
public class ImageIconLoadedState implements ImageState {
    ImageProxyIS imageProxy;
    ImageIcon imageIcon;

    public ImageIconLoadedState (ImageProxyIS imageProxy){
        this.imageProxy = imageProxy;
        imageIcon = imageProxy.getImageIcon();
    }

    @Override
    public int getIconWidth() {
        return imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return imageIcon.getIconHeight();
    }

    @Override
    public void paintIcon(final Component c, Graphics  g, int x, int y) {
        imageIcon.paintIcon(c, g, x, y);
        imageProxy.setState(imageProxy.getImageIconUnavailableState());
    }
}
