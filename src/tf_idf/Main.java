package tf_idf;

import java.io.Console;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		while (!ui.shouldQuit()) {
			ui.processNextIter();
		}
	}
}
