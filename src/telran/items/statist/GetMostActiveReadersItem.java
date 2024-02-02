package telran.items.statist;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetMostActiveReadersItem extends LibraryItem {

	public GetMostActiveReadersItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Get most active readers beetwen days";
	}

	@Override
	public void perform() {
		LocalDate from = inOut.inputDate("enter date from", "yyyy-MM-dd");
		LocalDate to = inOut.inputDate("enter date from", "yyyy-MM-dd");
		if(from == null || to == null || from.isBefore(to)) {
			inOut.outputLine("wrong dates");
			return;
		}
		inOut.outputLine("List most active readers beetwen dates " + from + " "+ to);
		library.getMostActiveReaders(from , to).forEach(inOut::outputLine);

	}

}
