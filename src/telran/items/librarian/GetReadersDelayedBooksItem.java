package telran.items.librarian;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReadersDelayedBooksItem extends LibraryItem {

	public GetReadersDelayedBooksItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get reader delayed books";
	}

	@Override
	public void perform() {
		inOut.outputLine("readers, delayed books");
		inOut.outputLine(library.getReadersDelayedBooks());
	}

}
