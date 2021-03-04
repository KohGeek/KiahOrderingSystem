package system_interface;

//Interface for any File IO
public interface IDatabase {
	public void initDataFromFile(String fileName);

	public void updateDataToFile(String fileName);
}
