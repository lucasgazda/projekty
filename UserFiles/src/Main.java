import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Set<User> listaUser = new HashSet<>();
		listaUser.add(new User("Gosia", "las", "user"));
		listaUser.add(new User("Lukasz", "zalas", "administrator"));
		listaUser.add(new User("Zofia", "przylas", "user"));
		listaUser.add(new User("Stanislaw", "przedlas", "user"));
		listaUser.add(new User("Grzegorz", "dolas", "user"));
		listaUser.add(new User("Jolanta", "odlas", "administrator"));
		
	
		Set<String> listaNazwPlikow = new HashSet<>();
		listaNazwPlikow.add("ZZ5_OKP2_Zad2_01");
		listaNazwPlikow.add("ZZ5_OKP2_Zad2_02");
		listaNazwPlikow.add("ZZ5_OKP2_Zad2_03");
		
		DataProcessing pd = new DataProcessing();
		
		pd.addData(new User("Gosia", "las", "administrator"), new Data(listaNazwPlikow));
		
		pd.filesManagement();

	}

}
