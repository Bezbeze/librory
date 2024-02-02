package telran.items.reader;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReaderPickedBooksItem extends LibraryItem {

	public GetReaderPickedBooksItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get reader picked book";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputLong("Enter book's id");
		if(!isBookExists(isbn))
			return;
		inOut.output(library.getReadersPickedBook(isbn));

	}

}
