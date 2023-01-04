package CoreJavaProject;


public class ClothingManagementSystem {

	public static void main(String[] args){
		try {
			DatabaseInterface.DBConnect();
			UIInterface.StartApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
