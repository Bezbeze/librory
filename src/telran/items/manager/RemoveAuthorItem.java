package telran.items.manager;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class RemoveAuthorItem extends LibraryItem {

	public RemoveAuthorItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Remove author";
	}

	@Override
	public void perform() {
		String authorName = inOut.inputString("Enter author name");
		inOut.outputLine("books wich was removed" + library.removeAuthor(authorName ));
	}

}
