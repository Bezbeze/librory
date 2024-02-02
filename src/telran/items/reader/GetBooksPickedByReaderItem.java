package telran.items.reader;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetBooksPickedByReaderItem extends LibraryItem {

	public GetBooksPickedByReaderItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get books picked by reader";
	}

	@Override
	public void perform() {
		int readerId = inOut.inputInteger("Enter reader id");
		if(!isReaderExists(readerId))
			return;
		library.getBooksPickedByReader(readerId).forEach(inOut::outputLine);
	}

}
