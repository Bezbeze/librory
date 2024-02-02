package telran.items;

import telran.library.model.ILibrary;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class LibraryItem implements Item {

	protected InputOutput inOut;
	protected ILibrary library;
	protected String nameFale;

	public LibraryItem(InputOutput inOut, ILibrary library, String nameFale) {
		this.inOut = inOut;
		this.library = library;
		this.nameFale = nameFale;
	}

	public boolean isBookExists(long isbn) {
		if (library.getBookItem(isbn) == null) {
			inOut.outputLine("Book does not exists");
			return false;
		}
		return true;
	}
	
	public boolean isReaderExists(int readerId) {
		if (library.getReader(readerId) == null) {
			inOut.outputLine("Reader does not exists");
			return false;
		}
		return true;
	}

}
