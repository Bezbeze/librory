package telran.items.librarian;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetAuthorBooksItem extends LibraryItem {

	public GetAuthorBooksItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}


	@Override
	public String displayedName() {
		return "Get books of Author";
	}

	@Override
	public void perform() {
		String authorName = inOut.inputString("Enter author name");
		if(library.getBooksAuthor(authorName) == null) {
			inOut.outputLine("author not exists in this library");
			return;
		}
		inOut.outputLine(library.getBooksAuthor(authorName));
	}

}
