package telran.library.dto;

import java.io.Serializable;
import java.util.List;

import telran.library.entities.Book;
import telran.library.entities.PickRecord;

@SuppressWarnings("serial")
public class RemovedBookData implements Serializable {
	
	private Book book;
	private List<PickRecord> records;
	
	
	public RemovedBookData() {
		
	}
	public RemovedBookData(Book book, List<PickRecord> records) {
		super();
		this.book = book;
		this.records = records;
	}
	public Book getBook() {
		return book;
	}
	public List<PickRecord> getRecords() {
		return records;
	}
	@Override
	public String toString() {
		return "RemovedBookData [book=" + book + ", records=" + records + "]";
	}
	
	
	
	

}
