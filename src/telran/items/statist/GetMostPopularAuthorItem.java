package telran.items.statist;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetMostPopularAuthorItem extends LibraryItem {

	public GetMostPopularAuthorItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get most popular author";
	}

	@Override
	public void perform() {
		inOut.outputLine("List of most popular author");
		library.getMostPopularAuthor().forEach(inOut::outputLine);

	}

}
