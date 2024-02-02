package telran.items.manager;

import telran.items.LibraryItem;
import telran.library.entities.Book;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.view.InputOutput;

public class AddBookItem extends LibraryItem {

	public AddBookItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "add new book";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputLong("Enter book id");
		if(isBookExists(isbn)) {
			inOut.outputLine("Book exists");
			return;
		}
		String title = inOut.inputString("Enter title");
		String author = inOut.inputString("Enter author");
		int amount = inOut.inputInteger("Enter pick period", 1, 1000);
		int minPickPeriod = ((LibraryMaps)library).getMinPickPeriod();
		int maxPickPeriod = ((LibraryMaps)library).getMaxPickPeriod();
		int pickPeriod  = inOut.inputInteger("Enter amount", minPickPeriod, maxPickPeriod);
		Book book = new Book(isbn , title , author, amount, pickPeriod);
		inOut.outputLine(library.addBookItem(book));
	}

}
