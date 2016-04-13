package headfirst.proxy.virtualproxyIS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by igors on 01.04.16.
 */
public class ImageIconUnavailableState implements ImageState {
    ImageProxyIS imageProxy;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageIconUnavailableState (ImageProxyIS imageProxy){
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }

    @Override
    public void paintIcon(final Component c, Graphics  g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x+300, y+190);
        //"retrieving" means "loading picture from internet". I'd use term "loading".
        if (!retrieving) {
            retrieving = true;

            retrievalThread = new Thread(new Runnable() {
                public void run() {
                    try { //Initialize "ImageIcon" object in the ImageProxy class
                        imageProxy.setImageIcon(new ImageIcon(imageProxy.getImageURL(), "CD Cover"));
                        imageProxy.setState(imageProxy.getImageIconLoadedState());
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            retrievalThread.start();
        }
    }
}
