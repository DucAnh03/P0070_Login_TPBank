package view;

import common.validation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public abstract class Menu {

    validation validation = new validation();
    Locale english = Locale.ENGLISH;
    
    private final String title;
    private final ArrayList<String> options = new ArrayList<>();

    public Menu(String title, String[] op) {
        this.title = title;
        this.options.addAll(Arrays.asList(op));
    }

    public void menuDisplay() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "." + options.get(i));
        }
        System.out.print("Please choice one option:");
    }

    public int getChoice() {
        menuDisplay();
        int choice = validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public void run() {
        while (true) {
            int choice = getChoice();
            execute(choice);
            if (choice > options.size() - 1) {
                break;
            }
        }
    }

    public abstract void execute(int n);
}
