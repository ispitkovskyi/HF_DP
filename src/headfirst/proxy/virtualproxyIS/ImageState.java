package headfirst.proxy.virtualproxyIS;

import java.awt.*;

/**
 * Created by igors on 01.04.16.
 */
public interface ImageState {
    public int getIconWidth();
    public int getIconHeight();
    public void paintIcon(Component c, Graphics  g, int x, int y);
}
