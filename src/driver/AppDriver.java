package driver;

import xmltools.XMLParser;


/**
 * Class description: This class is the driver for the XML Parser.
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 *
 */
public class AppDriver {
    public static void main(String[] args) {
        // Change the file name to test different XML files.
        // final String PATH = "res/sample1.xml";
        String PATH = args[0];
        System.out.println("Checking XML file: " + PATH);
        long startTime = System.currentTimeMillis();
        XMLParser parser = new XMLParser(PATH);
        long endTime = System.currentTimeMillis();
        System.out.println("Finished checking XML file: " + PATH + " with " + (endTime - startTime) + "ms");
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
