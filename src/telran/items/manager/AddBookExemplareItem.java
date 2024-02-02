package telran.items.manager;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class AddBookExemplareItem extends LibraryItem {

	public AddBookExemplareItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Add book exemplare";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputLong("Enter book id");
		if(!isBookExists(isbn))
			return;
		int count = inOut.inputInteger("Enter numbers of count books exemplars", 1, 1000);
		inOut.outputLine(library.addBookExemplars(isbn, count ));

	}

}
