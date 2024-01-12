package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import telran.library.dto.RemovedBookData;
import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.model.LibraryMaps;

class T {

	LibraryMaps library = new LibraryMaps();
	Book b1 = new Book(123456789L, "Test Book 1", "Test Author", 10, 20);
    Book b2 = new Book(12345678L, "Test Book 2", "Test Author", 10, 20);
    Book b3 = new Book(123456L, "Test Book 3", "Test Author", 10, 20);
    Reader r1 = new Reader(123, "n1", "1111111", LocalDate.now().minusYears(20));
    Reader r2 = new Reader(124, "n2", "2222222", LocalDate.now().minusYears(10));
    
	@Test
	void test() {
		library.addBookItem(b1);
        library.addBookItem(b2);
        library.addBookItem(b3);

        library.addReader(r1);
        library.addReader(r2);
        library.pickBook(b1.getIsbn(), r1.getReaderId(), LocalDate.now());
        library.pickBook(b2.getIsbn(), r2.getReaderId(), LocalDate.now());

        @SuppressWarnings("unused")
		List<RemovedBookData> removedBooks = library.removeAuthor("Test Author");
        assertEquals(null, library.getBookItem(b3.getIsbn()));
        assertEquals(-1, b1.getAmount());
        assertFalse(library.getBooksAuthor("Test Author").isEmpty());

        library.returnBook(b1.getIsbn(), r1.getReaderId(), LocalDate.now());
        assertEquals(null, library.getBookItem(b1.getIsbn()));
        assertFalse(library.getBooksAuthor("Test Author").isEmpty());

        library.returnBook(b2.getIsbn(), r2.getReaderId(), LocalDate.now());
        assertEquals(-1, b2.getAmount());

        assertEquals(null, library.getBookItem(b2.getIsbn()));
        assertEquals(library.getBooksAuthor("NO NAME AUTHOR"), library.getBooksAuthor("Test Author"));
        assertEquals(-1, b2.getAmount());
        

        
	}

}
