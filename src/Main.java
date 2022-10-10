import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("1. Show All Persons");
		System.out.println("2. Add a Person");
		System.out.println("3. Delete a Person");

		System.out.print("Choose your Option: ");
	}
	public static void main(String [] args) throws Exception {
		Scanner scanner = new Scanner(System.in);		// input
		DataBase dBase = new DataBase();
		
		while(true) {
		menu();
		int choice = scanner.nextInt();
		if(choice == 1) {
			// show data
			dBase.showData("select * from person");
		}
		else if(choice == 2) {
			String name, address;
			int rollNo, age;
			// add a person data
			System.out.print("Enter the Name of Person: ");
			name = scanner.next();
			
			System.out.print("Enter the Age of Person: ");
			age = scanner.nextInt();
			
			System.out.print("Enter the RollNo of Person: ");
			rollNo = scanner.nextInt();
			
			System.out.print("Enter the Address of Person: ");
			address = scanner.next();
		
			dBase.addPerson(name, address, rollNo, age);
		}
		else if(choice == 3) {
			// delete a person 
			int rollNo;
			System.out.print("Enter the RollNo of Person: ");
			rollNo = scanner.nextInt();
			dBase.deletePerson(rollNo);
		}
		

	}
	}
}
