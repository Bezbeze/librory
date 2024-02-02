package telran.items;

import telran.library.model.ILibrary;
import telran.utils.Persistable;
import telran.view.InputOutput;

public class ExitAndSaveItem extends LibraryItem {

	public ExitAndSaveItem(InputOutput inOut, ILibrary library, String nameFale) {
		super(inOut, library, nameFale);
	}

	@Override
	public String displayedName() {
		return "Save and exit";
	}

	@Override
	public void perform() {
		((Persistable) library).save(nameFale);

	}
	
	@Override
	public boolean isExit() {
		inOut.outputLine("Data was saved. Bye!");
		return true;
	}

}
