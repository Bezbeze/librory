package telran.items.librarian;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReadersDelayingBooksItem extends LibraryItem {

	public GetReadersDelayingBooksItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "get readers delaying books and not return yet";
	}

	@Override
	public void perform() {
		LocalDate date = inOut.inputDate("Enter date witch want to find out to delay", "yyyy-MM-dd");
		if(date == null)
			date = LocalDate.now();
		inOut.outputLine("list of readers delaying books and not rerturn yet on date" + date);
		inOut.outputLine(library.getReadersDelayingBooks(date));

	}

}
