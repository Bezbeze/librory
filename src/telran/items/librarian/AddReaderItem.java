package telran.items.librarian;

import java.time.LocalDate;

import telran.items.LibraryItem;
import telran.library.entities.Reader;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class AddReaderItem extends LibraryItem {

	public AddReaderItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Add reader";
	}

	@Override
	public void perform() {
		int readerId = inOut.inputInteger("Enter reader id");
		if(isReaderExists(readerId)){
			inOut.outputLine("reader id already exists");
			return;}
		
		String name = inOut.inputString("Enter name");
		String phone = inOut.inputString("Enter phone");
		LocalDate birthData = inOut.inputDate("Enter bithDate", "yyyy-MM-dd");
		Reader reader = new Reader(readerId , name , phone , birthData );
		inOut.outputLine(library.addReader(reader));

	}

}
