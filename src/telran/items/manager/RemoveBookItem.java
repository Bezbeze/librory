package telran.items.manager;

import telran.items.LibraryItem;
import telran.library.dto.RemovedBookData;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class RemoveBookItem extends LibraryItem {

	public RemoveBookItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Remove book";
	}

	@Override
	public void perform() {
		long isbn = inOut.inputLong("Enter book id");
		if(!isBookExists(isbn))
			return;
		RemovedBookData res = library.removeBook(isbn);
		inOut.output(res.getRecords()==null? "Book will be remote whetn all exemplars will be return":
			"book is Removed");
	}

}
