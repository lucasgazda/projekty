
public class Window {
	
	private double totalWidth;
	private double totalHeight;
	private double frameWidth;
	
	public double getTotalWidth() {
		return totalWidth;
	}
	
	public void setTotalWidth(double totalWidth) {
		if(totalWidth > 0)
		{
			this.totalWidth = totalWidth;
		}
		else
		{
			System.out.println("TOTAL WIDTH VALUE SMALLER OR EQUAL 0");
			this.totalWidth = 50;
		}
	}
	
	public double getTotalHeight() {
		return totalHeight;
	}
	
	public void setTotalHeight(double totalHeight) {
		if(totalHeight > 0)
		{
			this.totalHeight = totalHeight;
		}
		else
		{
			System.out.println("TOTAL HEIGHT VALUE SMALLER OR EQUAL 0");
			this.totalHeight = 80;
		}
	}
	
	public double getFrameWidth() {
		return frameWidth;
	}
	
	public void setFrameWidth(double frameWidth) {
		if((frameWidth * 2) <= (getTotalWidth() * 0.1))
		{
			this.frameWidth = frameWidth;
		}
		else
		{
			System.out.println("FRAME WIDTH VALUE SMALLER OR EQUAL 0");
			this.frameWidth = 3;
		}
	}

	public Window() {
		
	}

	public Window(double totalWidth, double totalHeight, double frameWidth) {
		setTotalWidth(totalWidth);
		setTotalHeight(totalHeight);
		setFrameWidth(frameWidth);
	}

	public double calculateGlass() {
		return (getTotalWidth() - (2 * getFrameWidth())) * (getTotalHeight() - (2 * getFrameWidth()));
	}
	
	public double windowPrice(double framePrice, double glassPrice) {
		return (glassPrice * calculateGlass()) + (framePrice * ((getTotalWidth() * getTotalHeight()) - calculateGlass()));
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "TOTAL WIDTH = " + totalWidth + "\n";
			text += "TOTAL HIGHT = " + totalHeight + "\n";
			text += "FRAME WIDTH = " + frameWidth + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(totalWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(frameWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalHeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Window other = (Window) obj;
		if (Double.doubleToLongBits(totalWidth) != Double.doubleToLongBits(other.totalWidth))
			return false;
		if (Double.doubleToLongBits(frameWidth) != Double.doubleToLongBits(other.frameWidth))
			return false;
		if (Double.doubleToLongBits(totalHeight) != Double.doubleToLongBits(other.totalHeight))
			return false;
		return true;
	}
}
