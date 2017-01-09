//		KM PROGRAMS		http://km-programs.pl/

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Set<User> userList = new HashSet<>();
		userList.add(new User("Gosia", "Kowalska", "user"));
		userList.add(new User("Lukasz", "Brzeczyszczykiewicz", "administrator"));
		userList.add(new User("Zofia", "Pelczar", "user"));
		userList.add(new User("Stanislaw", "Dolas", "user"));
		userList.add(new User("Grzegorz", "Pietruszka", "user"));
		userList.add(new User("Jolanta", "Walesa", "administrator"));
		
		Set<String> fileList = new HashSet<>();
		fileList.add("file_01");
		fileList.add("file_02");
		fileList.add("file_03");
		
		DataProcessing dataprocessing = new DataProcessing();
		
		dataprocessing.addDataProcessing(new User("Stanislaw", "Dolas", "user"), new Data(fileList));
		dataprocessing.filesManagement();
		
		dataprocessing.addDataProcessing(new User("Jolanta", "Walesa", "administrator"), new Data(fileList));
		dataprocessing.filesManagement();

	}

}
