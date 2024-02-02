package telran.appl;

import telran.items.ExitAndSaveItem;
import telran.items.librarian.AddReaderItem;
import telran.items.librarian.GetAuthorBooksItem;
import telran.items.librarian.GetReadersDelayedBooksItem;
import telran.items.librarian.GetReadersDelayingBooksItem;
import telran.items.librarian.PickBookItem;
import telran.items.manager.AddBookExemplareItem;
import telran.items.manager.AddBookItem;
import telran.items.manager.RemoveAuthorItem;
import telran.items.manager.RemoveBookItem;
import telran.items.reader.GetBookItem;
import telran.items.reader.GetBooksPickedByReaderItem;
import telran.items.reader.GetReaderItem;
import telran.items.reader.GetReaderPickedBooksItem;
import telran.items.statist.GetMostActiveReadersItem;
import telran.items.statist.GetMostPopularAuthorItem;
import telran.items.statist.GetMostPopularBooksItem;
import telran.items.tecthnician.GetPickedRecordsByDatesItem;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.view.ConsoleInputOutPut;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubMenuItem;

public class LibraryMenuAppl {
	private static final String NAME_FILE =  "test.book";
	private static final InputOutput iout = new ConsoleInputOutPut();
	private static ILibrary library;

	public static void main(String[] args) {
		library = LibraryMaps.restoreFromFile(NAME_FILE);
		Menu menu = new Menu(getArrayOfSubMenu(), iout);
		menu.runMenu();

	}

	private static Item[] getArrayOfSubMenu() {
		Item[] items = {
				new SubMenuItem(iout, geLibrarianMenu(), "Librarian"),
				new SubMenuItem(iout, getTecthnicianMenu(), "Tecthnician"),
				new SubMenuItem(iout, getManagerMenu(), "Manager"),
				new SubMenuItem(iout, getStatistMenu(), "Statist"),
				new SubMenuItem(iout, geReaderMenu(), "Reader"),
				new ExitAndSaveItem(iout, library, NAME_FILE),
				new ExitItem()
				
		};
		return items;
	}

	private static Item[] geReaderMenu() {
		Item[] items = {
				new GetBookItem(iout, library, NAME_FILE),
				new GetBooksPickedByReaderItem(iout, library, NAME_FILE),
				new GetReaderItem(iout, library, NAME_FILE),
				new GetReaderPickedBooksItem(iout, library, NAME_FILE),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getStatistMenu() {
		Item[] items = {
				new GetMostActiveReadersItem(iout, library, NAME_FILE),
				new GetMostPopularAuthorItem(iout, library, NAME_FILE),
				new GetMostPopularBooksItem(iout, library, NAME_FILE),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getManagerMenu() {
		Item[] items = {
				new AddBookExemplareItem(iout, library, NAME_FILE),
				new AddBookItem(iout, library, NAME_FILE),
				new RemoveAuthorItem(iout, library, NAME_FILE),
				new RemoveBookItem(iout, library, NAME_FILE),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getTecthnicianMenu() {
		Item[] items = {
				new GetPickedRecordsByDatesItem(iout, library, NAME_FILE),
				new ExitItem()
				
		};
		return items;
	}

	private static Item[] geLibrarianMenu() {
		Item[] items = {
				new PickBookItem(iout, library, NAME_FILE),
				new AddReaderItem(iout, library, NAME_FILE),
				new GetAuthorBooksItem(iout, library, NAME_FILE),
				new GetReadersDelayedBooksItem(iout, library, NAME_FILE),
				new GetReadersDelayingBooksItem(iout, library, NAME_FILE),
				new ExitItem()
		};
		return items;
	}

}
