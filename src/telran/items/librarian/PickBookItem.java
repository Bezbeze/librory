package telran.items.librarian;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class PickBookItem extends LibraryItem {

	public PickBookItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Pick book";
	}

	@Override
	public void perform() {
		long isbh = inOut.inputLong("Enter book id");
		if(!isBookExists(isbh))
			return;
		int readerId = inOut.inputInteger("Enter reader id");
		if(library.getReader(readerId) == null){
			inOut.outputLine("Wrong reader id, don't find reader with this id");
			return;
		}
		inOut.outputLine(library.pickBook(isbh, readerId, LocalDate.now()));
	}

}
