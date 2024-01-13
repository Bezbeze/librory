package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.entities.ReaderDelay;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;

class LibraryMapsTestStatistic {
	static ILibrary librory = new LibraryMaps();
	static Book b1 = new Book(1, "title1", "Author1", 4, 5);
	static Book b2 = new Book(2, "title1", "Author2", 4, 5);
	static Book b3 = new Book(3, "title1", "Author2", 4, 5);
	static Book b4 = new Book(4, "title1", "Author2", 4, 5);
	static Book b5 = new Book(5, "title1", "Author2", 4, 5);
	
	static Reader r1 = new Reader(1, "name", "123", LocalDate.of(1990, 1, 1));
	static Reader r2 = new Reader(2, "name", "123", LocalDate.of(1970, 1, 1));
	static Reader r3 = new Reader(3, "name", "123", LocalDate.of(2005, 1, 1));
	static LocalDate datePick = LocalDate.of(2023, 1, 1);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		librory.addBookItem(b1);
		librory.addBookItem(b2);
		librory.addBookItem(b3);
		librory.addBookItem(b4);
		librory.addBookItem(b5);
		librory.addReader(r1);
		librory.addReader(r2);
		librory.addReader(r3);
		librory.pickBook(1, 1, datePick.minusDays(10));
		librory.pickBook(2, 1, datePick.minusDays(7)); //delay 2 days, not retured
		librory.pickBook(5, 1, datePick.minusDays(2));
		librory.pickBook(1, 2, datePick.minusDays(10));
		librory.pickBook(1, 3, datePick.minusDays(10)); //delay 5d ays, not retured
		librory.pickBook(4, 2, datePick.minusDays(6));
		librory.pickBook(2, 3, datePick.minusDays(4));
		librory.returnBook(1, 1, datePick);  //delay 5days
		librory.returnBook(5, 1, datePick); 
		librory.returnBook(1, 2, datePick); //delay 5days
		librory.returnBook(4, 2, datePick); //delay 1 days
		
	}


	@Test
	void testGetReadersDelayingBooks() {
		List<ReaderDelay> res = librory.getReadersDelayingBooks(datePick);
		assertEquals(2, res.size());
		assertEquals(3, res.get(0).getReader().getReaderId());
		assertEquals(1, res.get(1).getReader().getReaderId());
	}

	@Test
	void testGetReadersDelayedBooks() {
		List<ReaderDelay> res = librory.getReadersDelayedBooks();
		assertEquals(2, res.size());
		assertEquals(2, res.get(0).getReader().getReaderId());
		assertEquals(6, res.get(0).getDelay());
		assertEquals(1, res.get(1).getReader().getReaderId());
	}

	@Test
	void testGetMostPopularBooks() {
		List<Book> res = librory.getMostPopularBooks(datePick.minusDays(10), datePick, 10, 30);
		assertEquals(2, res.size());
		assertTrue(res.contains(librory.getBookItem(1)));
		assertTrue(res.contains(librory.getBookItem(2)));
	}

	@Test
	void testGetMostPopularAuthor() {
		List<String> res = librory.getMostPopularAuthor();
		assertEquals(1, res.size());
		assertTrue(res.contains("Author2"));
		
	}

	@Test
	void testGetMostActiveReaders() {
		List<Reader> res = librory.getMostActiveReaders(datePick.minusDays(12), datePick);
		assertEquals(1, res.size());
		assertTrue(res.contains(r1));
	}

}
