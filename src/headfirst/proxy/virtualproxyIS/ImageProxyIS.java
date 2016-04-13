package headfirst.proxy.virtualproxyIS;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class ImageProxyIS implements Icon {
	URL imageURL;
	ImageIcon imageIcon;  // ImageIcon - class of "javax.swing" package, which implements interface Icon.
	ImageState currentState;
	ImageState imageIconUnavailableState;
	ImageState imageIconLoadedState;

	public ImageProxyIS(URL url) {
		imageURL = url;
		//Create just initial instances of both states (passing "empty" ImageProxy object, which contains ImageIcon = null)
		imageIconUnavailableState = new ImageIconUnavailableState(this);
		imageIconLoadedState = new ImageIconLoadedState(this);

		currentState = imageIconUnavailableState;
	}

	public ImageState getImageIconUnavailableState(){
		return new ImageIconUnavailableState(this);
	}

	public ImageState getImageIconLoadedState(){
		return new ImageIconLoadedState(this);
	}

	public void setState(ImageState newState){
		currentState = newState;
	}

	public void setImageIcon(ImageIcon imageIcon){
		this.imageIcon = imageIcon;
	}

	public ImageIcon getImageIcon(){
		return this.imageIcon;
	}

	public int getIconWidth() {
		return currentState.getIconWidth();
	}
 
	public int getIconHeight() {
		return currentState.getIconHeight();
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		currentState.paintIcon(c, g, x, y);
	}

	public URL getImageURL(){
		return imageURL;
	}
}
