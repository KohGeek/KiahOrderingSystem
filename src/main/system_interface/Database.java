package system_interface;

import java.util.ArrayList;

import system_entity.Member;

public interface Database {

	public void initDataFromFile(String fileName);

	public void updateDataToFile(String fileName);
	
	public ArrayList<Member> getData();

}
