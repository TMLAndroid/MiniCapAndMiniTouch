/**
 * 
 */
package com.company.minicap;

import java.awt.Image;


 
public interface ScreenSubject {
	public void registerObserver(AndroidScreenObserver o);

	public void removeObserver(AndroidScreenObserver o);

	public void notifyObservers(Image image);

}
