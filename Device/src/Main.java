//		KM PROGRAMS		http://km-programs.pl/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	
	public static Map<Device, Boolean> deviceInspection(Set<Device> deviceSet, Map<String, Integer> m) {
		Map<Device, Boolean> inspectionList = new HashMap<>();
		
		for(Device device: deviceSet) {
			if(m.get(device.getDeviceClass()) < device.getTotalWorkingTime())
			{
				inspectionList.put(device, true);
			}
			else
			{
				inspectionList.put(device, false);
			}
		}
		return inspectionList;
	}
	
	public static double reparingPrice(Map<Device, Boolean> deviceMap) {
		double reparingPrice = 0;
		for(Entry<Device, Boolean> e: deviceMap.entrySet())
		{
			if(e.getValue() == true)
			{
				reparingPrice += e.getKey().getDeviceReparingPrice();
			}
		}
		return reparingPrice;
	}

	public static void main(String[] args) {

		Set<Device> deviceList = new HashSet<>();
		deviceList.add(new Device("WASHER", 120, "A", 100));
		deviceList.add(new Device("FRIDGE", 60, "D", 90));
		deviceList.add(new Device("MICROWAVE", 80, "C", 110));
		deviceList.add(new Device("INDUCTION HOB", 110, "B", 110));
		deviceList.add(new Device("COOKER", 100, "A", 110));
		deviceList.add(new Device("OVEN", 91, "B", 100));
		deviceList.add(new Device("WASHING MACHINE", 71, "C", 80));
		
		Map<String, Integer> repairGuidelines = new HashMap<>();
		repairGuidelines.put("A", 110);
		repairGuidelines.put("B", 90);
		repairGuidelines.put("C", 70);
		repairGuidelines.put("D", 50);
		
		System.out.println(deviceInspection(deviceList, repairGuidelines));
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("DEVICE REPARING PRICE " + reparingPrice(deviceInspection(deviceList, repairGuidelines)));
	}

}
