/**
 * This package contains the driver class for the application.
 */
package driver;

import xmltools.XMLParser;


/**
 * Class description: This class is the driver for the XML Parser
 * this class use to test the application and display the result on the screen.
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 *
 */
public class AppDriver {
    public static void main(String[] args) {
        boolean error = false;
        String fileName = args[0];
        if(!fileName.startsWith("-") || fileName.toLowerCase().charAt(1)!= 'f') {
            System.out.println("Invalid command line argument, the command line argument should be -f<FilePath>");
            error = true;
        }
        if (!error) {
            String path = fileName.substring(2).toLowerCase();
            System.out.println("Checking XML file: " + path);
            long startTime = System.currentTimeMillis();
            XMLParser parser = new XMLParser(path);
            long endTime = System.currentTimeMillis();
            System.out.println("Finished checking " + path + " file with " + (endTime - startTime) + "ms.");
            System.out.println(
                    "        _   _         _  _          _   __ _\n" +
                            "       | | | |  ___  | || |  ___   | | / /(_)  _     _\n" +
                            "       | |_| | / _ \\ | || | / _ \\  | |/ /  _ _| |_ _| |_  _  _\n" +
                            "       |  _  |/ /_\\ \\| || |/ / \\ \\ |   /  | |_   _|_   _|| |/ /\n" +
                            "       | | | |\\ ,___/| || |\\ \\_/ / | |\\ \\ | | | |_  | |_ | / /\n" +
                            "       |_| |_| \\___/ |_||_| \\___/  |_| \\_\\|_| \\___| \\___||  /\n" +
                            "                              _           _              / /\n" +
                            "                             / \\_______ /|_\\             \\/\n" +
                            "                            /          /_/ \\__\n" +
                            "                           /             \\_/ /\n" +
                            "                         _|_              |/|_\n" +
                            "                         _|_  O    _    O  _|_\n" +
                            "                         _|_      (_)      _|_\n" +
                            "                          \\                 /\n" +
                            "                           _\\_____________/_\n" +
                            "                          /  \\/  (___)  \\/  \\\n" +
                            "                          \\__(  o     o  )__/\n" +
                            "Team Aerith:\n" +
                            "            Hoa Le, Weilong Mao, Chris Wang, Hu Peng\n" +
                            "Ver: 2022-11-06");
        }

    }
}
