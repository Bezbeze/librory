package telran.items.reader;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReaderItem extends LibraryItem {

	public GetReaderItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get reader";
	}

	@Override
	public void perform() {
		int readerId = inOut.inputInteger("Enter reader id");
		if(!isReaderExists(readerId))
			return;
		inOut.outputLine(library.getReader(readerId));

	}

}
