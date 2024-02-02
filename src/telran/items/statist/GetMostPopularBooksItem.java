package telran.items.statist;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetMostPopularBooksItem extends LibraryItem {

	public GetMostPopularBooksItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get most popular books";
	}

	@Override
	public void perform() {
		LocalDate from = inOut.inputDate("enter date from", "yyyy-MM-dd");
		LocalDate to = inOut.inputDate("enter date from", "yyyy-MM-dd");
		if(from == null || to == null || from.isBefore(to)) {
			inOut.outputLine("wrong dates");
			return;
		}
		Integer fromAge = inOut.inputInteger("Enter from age");	
		Integer toAge = inOut.inputInteger("Enter to age");
		if(fromAge == null || toAge == null) return;	
		library.getMostPopularBooks(from, to, fromAge, toAge).forEach(inOut::outputLine);;
	}

}
