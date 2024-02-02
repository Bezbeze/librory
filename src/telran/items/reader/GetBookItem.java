package telran.items.reader;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetBookItem extends LibraryItem {

	public GetBookItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get book";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputLong("Enter book id");
		if(!isBookExists(isbn))
			return;
		inOut.outputLine(library.getBookItem(isbn ));
	}

}
