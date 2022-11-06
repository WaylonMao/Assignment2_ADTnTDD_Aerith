package driver;

import xmltools.XMLParser;


/**
 * Class description: This class is the driver for the XML Parser.
 *
 * @author Weilong Mao
 */
public class AppDriver {
    public static void main(String[] args) {
        // Change the file name to test different XML files.
        // final String PATH = "res/sample1.xml";
        final String PATH = "res/sample2.xml";
        System.out.println("Checking XML file: " + PATH);
        XMLParser parser = new XMLParser(PATH);
        System.out.println("Finished.");
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
