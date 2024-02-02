package telran.items.tecthnician;

import java.time.LocalDate;
import java.util.List;

import telran.items.LibraryItem;
import telran.library.entities.PickRecord;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetPickedRecordsByDatesItem extends LibraryItem {

	public GetPickedRecordsByDatesItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);

	}


	@Override
	public String displayedName() {
		return "Get picked records by dates";
	}

	@Override
	public void perform() {
		LocalDate from = inOut.inputDate("enter date from", "yyyy-MM-dd");
		LocalDate to = inOut.inputDate("enter date from", "yyyy-MM-dd");
		if(from == null || to == null || from.isBefore(to)) {
			inOut.outputLine("wrong dates");
			return;
		}
			
		List<PickRecord> res = library.getPickedRecordsAtDates(from , to );
		res.forEach(inOut::outputLine);
		}

}
