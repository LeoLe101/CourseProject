package le;

import javafx.application.Application;

/**
 * This is the launcher class for the project. It will launch the GUI for the
 * user to interact with the program.
 *
 * @author Phuc Hong Le
 * @version 1 (3/1/2017)
 */
public class Launcher {

    /**
     * Launcher for the GUI
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(GunDealerGUI.class);
    }
}
