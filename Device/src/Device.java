
public class Device {

	private String deviceName;
	private int totalWorkingTime;
	private String deviceClass;
	private double deviceReparingPrice;
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	public int getTotalWorkingTime() {
		return totalWorkingTime;
	}
	
	public void setTotalWorkngTime(int totalWorkingTime) {
		if(0 <= totalWorkingTime && totalWorkingTime <= 120)
		{
			this.totalWorkingTime = totalWorkingTime;
		}
		else
		{
			System.out.println("INCORRECT WORKING TIME VALUE");
			this.totalWorkingTime = 60;
		}
	}
	
	public String getDeviceClass() {
		return deviceClass;
	}
	
	public void setDeviceClass(String deviceClass) {
		if(deviceClass.matches("(A|B|C|D)"))
		{
			this.deviceClass = deviceClass;
		}
		else
		{
			System.out.println("INCORRECT DEVICE CLASS VALUE");
			this.deviceClass = "A";
		}
	}
	
	public double getDeviceReparingPrice() {
		return deviceReparingPrice;
	}
	
	public void setDeviceReparingPrice(double deviceReparingPrice) {
		this.deviceReparingPrice = deviceReparingPrice;
	}

	public Device() {
		
	}

	
	
	public Device(String deviceName, int totalWorkingTime, String deviceClass, double deviceReparingPrice) {
		this.deviceName = deviceName;
		setTotalWorkngTime(totalWorkingTime);
		setDeviceClass(deviceClass);
		this.deviceReparingPrice = deviceReparingPrice;
	}

	@Override
		public String toString() {
			String text = "";
			text += "\n" + "DEVICE NAME = " + getDeviceName() + "\n";
			text += "TOTAL WORKING TIME = " + getTotalWorkingTime() + "\n";
			text += "DEVICE CLASS = " + getDeviceClass() + "\n";
			text += "DEVICE REPARING PRICE = " + getDeviceReparingPrice() + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceClass == null) ? 0 : deviceClass.hashCode());
		long temp;
		temp = Double.doubleToLongBits(deviceReparingPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + totalWorkingTime;
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
		Device other = (Device) obj;
		if (deviceClass == null) {
			if (other.deviceClass != null)
				return false;
		} else if (!deviceClass.equals(other.deviceClass))
			return false;
		if (Double.doubleToLongBits(deviceReparingPrice) != Double.doubleToLongBits(other.deviceReparingPrice))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (totalWorkingTime != other.totalWorkingTime)
			return false;
		return true;
	}
	
}