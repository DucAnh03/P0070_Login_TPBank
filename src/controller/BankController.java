package controller;

import common.Algorithm;
import java.util.Locale;
import view.Menu;

public class BankController {

    private final String[] MAIN_MENU_ITEMS = {
        " Vietnamese",
        " English",
        " Exit"};
    Algorithm algorithm;

    public BankController() {
        algorithm = new Algorithm();
    }

    Locale vietnamese = new Locale("vi");
    Locale english = Locale.ENGLISH;
    Menu mnu = new Menu("Login program", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.login(vietnamese);
                    break;
                case 2:
                    algorithm.login(english);
                    break;

                case 3:
                    System.exit(0);
                    break;

            }

        }

    };

    public void run() {
        mnu.run();
    }

}
