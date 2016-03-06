import java.io.Serializable;

public class Book implements Serializable {
	private String novel, artalbums;
	private String title, author;
	
	public Book(){
		novel = null;
		artalbums = null;
		title = null;
		author = null;
	}
	public Book (String title, String author, String novel, String artalbums){
		this.title = title;
		this.author = author;
		this.novel = novel;
		this.artalbums = artalbums;
	}
	@Override
	public String toString(){
		return "\nTitle: " + title + "\nAuthor: "+author + "\nNovel: "+ novel +
				"\nArtAlbums: "+ artalbums + "\n";
	}
	
}
