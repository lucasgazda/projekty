
import java.io.File;
import java.io.FileNotFoundException;
import java.io.LineNumberInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DataProcessing {

	private Map<User, Data> mapDataProcessing = new HashMap<>();
	
	
	public Map<User, Data> getMapDataProcessing() {
		return mapDataProcessing;
	}

	public void addData(User user, Data data) {
		mapDataProcessing.put(user, data);
	}

	public DataProcessing() {
		
	}

	public DataProcessing(Map<User, Data> mapDataProcessing) {
		this.mapDataProcessing = mapDataProcessing;
	}
	
	public void filesManagement() {
		Scanner sc = new Scanner(System.in);
		for(Entry<User, Data> e: mapDataProcessing.entrySet())
		{
			if(e.getKey().getRole() == "administrator")
			{
				String end = "";
				do
				{
					try {
						Map<String, String> listFiles = e.getValue().getMapaNapis();
						
						for(Entry<String, String> w: listFiles.entrySet())
						{
							System.out.println("FILE: " + w.getKey() + " CONTENT: " + w.getValue());
						}
						
						System.out.println("Write file to change");
						String fileChange = sc.nextLine();
						String fileName = "G:\\Programowanie\\TxtFiles\\" + fileChange + ".txt";
						File file = new File(fileName);
						PrintWriter pw = new PrintWriter(file);
						System.out.println("Write content to save");
						String saveContent = sc.nextLine();
						pw.println(saveContent);
						pw.close();
						
						System.out.println("End modification files Y/N");
						end = sc.nextLine();
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				while(!end.matches("Y"));
			}
			else
			{
				System.out.println("Write word to search");
				String wordSearch = sc.nextLine();
				int apperanceAmountWordSearch = 0;
				
				Map<String, String> temp = e.getValue().getMapaNapis();
				
				for(Entry<String, String> s: temp.entrySet())
				{
					if(s.getValue().matches(wordSearch))
					{
						apperanceAmountWordSearch++;
					}
				}
				System.out.println("Word " + wordSearch + " appears " + apperanceAmountWordSearch + " times");
			}
		}
	}
	
	@Override
		public String toString() {
			return "MAP DATA PROCESSING = " + getMapDataProcessing() + "\n";
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapDataProcessing == null) ? 0 : mapDataProcessing.hashCode());
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
		DataProcessing other = (DataProcessing) obj;
		if (mapDataProcessing == null) {
			if (other.mapDataProcessing != null)
				return false;
		} else if (!mapDataProcessing.equals(other.mapDataProcessing))
			return false;
		return true;
	}
}

