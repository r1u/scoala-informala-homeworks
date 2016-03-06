import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class mainSystem {
	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static boolean running = true;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nPress 0 to load the Library. " + "\nPress 1 to save and quit. "
					+ "\nPress 2 to list all the books in Library. " + "\nPress 3 to add book to Library. ");
			int answer = in.nextInt();	
			switch(answer){
			case 0:
				System.out.println("Enter the file name to load ");
				loadScript(in.next());
				break;
			case 1:
				saveAndQuit();
				
				break;
			case 2:
				System.out.println(lib.toString());
				break;
			case 3:
				addBook();
				
				break;
			}
		}
		System.exit(0);
	}

	private static void addBook() {
		// TODO Auto-generated method stub
		String title, author, artalbums, novel;
		System.out.println("\nEnter Title: ");
		title = in.next();
		System.out.println("\nEnter Author: ");
		author = in.next();
		System.out.println("\nEnter Novel: ");
		novel = in.next();
		System.out.println("\nEnter ArtAlbums: ");
		artalbums = in.next();
		
		Book b = new Book (title, author, novel, artalbums);
		lib.addBook(b);
		
	}

	private static void saveAndQuit() {
		// TODO Auto-generated method stub
		System.out.println("Enter file name: ");
		fileName = in.next() + ".ser";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
		fos = new FileOutputStream(fileName);
		out = new ObjectOutputStream(fos);
		out.writeObject(lib);
		fos.close();
		out.close();
		
	} catch (FileNotFoundException e){
		e.printStackTrace(); 
	} catch (IOException e){
		e.printStackTrace();
		}
	}
		

	private static void loadScript(String name) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File(fileName + ".ser");
		if (file.exists())
			
		
		try {
			fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			lib = (Library)in.readObject();
			fis.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} else {
		System.out.println("\nThe file does not exist! ");
	}
	}
}
