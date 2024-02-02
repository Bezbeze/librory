package telran.items.librarian;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class ReturnBookItem extends LibraryItem {

	public ReturnBookItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Return book";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputInteger("Enter id of book");
		if(!isBookExists(isbn))
			return;
		int readerId = inOut.inputInteger("Enter reader id");
		if(!isReaderExists(readerId)) 
			return;
		inOut.outputLine(library.returnBook(isbn , readerId, LocalDate.now()));
	}

}
