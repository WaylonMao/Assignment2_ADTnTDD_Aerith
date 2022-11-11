1. Program name: ADT STACK, ADT QUEUE – XML PARSER

2. This application is used to parse XML document files and display errors from XML document files
   into the console. The application uses Stack and Queue that build from our design without using
   Java API.

3. Date completed: November 11, 2022

4. Author: Weilong Mao, Hoa Le, Chris Wang, Hu Peng

5. Please check the program package to see all the following files used to run

	- Parser.jar file: it uses to run programs on the command line.
	- readMe.txt file: the instruction on how to run this program.
	- A folder containing the complete Eclipse project directory.

6. Command line format explanation:
   To run the program properly, the user needs to the key command line correctly to avoid any program disruption.
   The format command line is used on this application base on the following:

   -> java -jar Parser.jar -f"sample1.xml"

   + java -jar is used for running an executable Java Archive file
   + Parser.jar is this program's jar file name
   + -f is defined as starting a txt file, the program will show an error when the user misses - or f.
   + sample1.xml is the XML file name used for the test program, the user can change to different files using XML format.

7. How to run this program: This program requires the user to enter the path of the XML file.
   There are three ways that you can parse XML files with this program:

    a/ sample.xml file placed at Parser.jar: in this case, the key command line following the format

        java -jar Parser.jar -fsample1.xml

    b/ sample.xml file placed at res source folder: in this case, the key command line following the format

        java -jar Parser.jar -f"res\sample1".xml

	    **Please make sure to place" " similar on the command line as the format above

    c/ sample.xml file placed at the assigned directory in your machine: in this case, the key command line following the format

	    java -jar Parser.jar -f"C:\temp\sample1.xml"

	    **Please make sure to place" " similar on the command line as the format above

        ***PLEASE PAY ATTENTION TO command line explanation on 6 to key correctly command line ***

8. After running the program, the errors will be displayed on the console if the XML has errors. If the XML file is valid,

        the program will display "No errors found".


        We hope you are enjoying this program.

        Thank you for your patience to read to the end.
