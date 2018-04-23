/**
 * 
 */
package com.company.minicap;

 
public class Banner {
	@Override
	public String toString() {
		return "Banner [version=" + version + ", length=" + length + ", pid="
				+ pid + ", readWidth=" + readWidth + ", readHeight="
				+ readHeight + ", virtualWidth=" + virtualWidth
				+ ", virtualHeight=" + virtualHeight + ", orientation="
				+ orientation + ", quirks=" + quirks + "]";
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getReadWidth() {
		return readWidth;
	}
	public void setReadWidth(int readWidth) {
		this.readWidth = readWidth;
	}
	public int getReadHeight() {
		return readHeight;
	}
	public void setReadHeight(int readHeight) {
		this.readHeight = readHeight;
	}
	public int getVirtualWidth() {
		return virtualWidth;
	}
	public void setVirtualWidth(int virtualWidth) {
		this.virtualWidth = virtualWidth;
	}
	public int getVirtualHeight() {
		return virtualHeight;
	}
	public void setVirtualHeight(int virtualHeight) {
		this.virtualHeight = virtualHeight;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public int getQuirks() {
		return quirks;
	}
	public void setQuirks(int quirks) {
		this.quirks = quirks;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	public int getMaxPress() {
		return maxPress;
	}

	public void setMaxPress(int maxPress) {
		this.maxPress = maxPress;
	}

	private int version;
	private int length;
	private int pid;
	private int readWidth;
	private int readHeight;
	private int virtualWidth;
	private int virtualHeight;
	private int orientation;
	private int quirks;
	private int maxX;
	private int maxY;
	private int maxPoint;
	private int maxPress;

	
	
	
}
