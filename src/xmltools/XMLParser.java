package xmltools;

import utilities.Iterator;
import utilities.MyQueue;
import utilities.MyStack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class description: This class is a parser for XML files. It will parse the
 * file, check for errors, and print out the errors.
 * First it use a stack to get the tags and check if they are right. Then it
 * use a queue to store the xml lines and a stack to store the xml tags. It
 * will check if the tags are matched and if the tags are in the right order.
 * If there is an error, it will store the error in a queue.
 * Then, it will check tags stack to see if there is any tag left in the stack.
 * If there is, it will store the error in the queue.
 * After that, it will check queues and print out the errors.
 *
 * @author Weilong Mao
 */
public class XMLParser {
    /**
     * The open tag symbol.
     */
    private static final char OPEN_TAG = '<';

    /**
     * The close tag symbol.
     */
    private static final char CLOSE_TAG = '>';

    /**
     * The slash symbol.
     */
    private static final char SLASH = '/';

    /**
     * The space symbol.
     */
    private static final char SPACE = ' ';

    /**
     * The question symbol.
     */
    private static final char QUESTION = '?';

    /**
     * The path of the XML file.
     */
    private String xmlFilePath;

    /**
     * This queue stores all characters of a XML line.
     */
    private MyQueue<Character> xmlLine;

    /**
     * This queue stores all xmlLine.
     */
    private MyQueue<MyQueue<Character>> xmlLines;

    /**
     * The stack of the XML tag's characters.
     */
    private MyStack<Character> tagStack;

    /**
     * The stack of the XML tags.
     */
    private MyStack<XMLTag> tagsStack;

    /**
     * The queue of the errors.
     */
    private MyQueue<XMLTag> errorQueue;

    /**
     * The queue of the extra tags.
     */
    private MyQueue<XMLTag> extrasQueue;

    /**
     * The line number of the XML file.
     */
    private int lineNum = 1;

    /**
     * The name of the XML tag.
     */
    private String tagName = "";

    /**
     * The value will be true, if there is an error in the XML file.
     */
    private boolean isError = false;

    /**
     * This is the constructor of the XMLParser class.
     * It will initialize the queues and stacks.
     * Then it will call the parse method to parse the XML file.
     *
     * pre-condition: The XML file must be existed and in the right format.
     * post-condition: The XML file will be parsed. If there is any error, it
     * will be stored in the error queue.
     *
     * @param xmlFilePath The path of the XML file.
     */
    public XMLParser(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        xmlLine = new MyQueue<>();
        xmlLines = new MyQueue<>();
        tagStack = new MyStack<>();
        tagsStack = new MyStack<>();
        errorQueue = new MyQueue<>();
        extrasQueue = new MyQueue<>();
        initialXMLLines();
        parserTags();
        checkError();
        if(!isError) {
            System.out.println("No error found.");
        }
    }

     /**
      * This method is used to get the XML lines from the XML file.
      *
      * pre-condition: The XML file must be existed and in the right format.
      * post-condition: The XML lines will be stored in the xmlLines queue.
      *
      */
    private void initialXMLLines() {
        try {
            Scanner scanner = new Scanner(new FileReader(xmlFilePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    xmlLine = new MyQueue<>();
                    for (char c : line.toCharArray()) {
                        xmlLine.enqueue(c);
                    }
                    xmlLines.enqueue(xmlLine);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found!");
            e.printStackTrace();
        }
    }

    /**
     * This method is used to parse the XML file.
     *
     * pre-condition: The XML lines are stored in the XMLLines queue.
     * post-condition: The XML file will be parsed. If there is any error, it
     * will be stored in the error queue.
     *
     */
    private void parserTags() {

        boolean foundOpenTag = false;
        this.lineNum = 1;
        char c = SPACE;

        // Loop through the XML lines and add the characters from the XML lines to xmlLine queue.
        while (!xmlLines.isEmpty()) {
            String line = "";
            boolean error = false;
            xmlLine = xmlLines.dequeue();
            line = xmlLine.toArray().toString();

            // Loop through an XML line.
            while (!xmlLine.isEmpty()) {
                // Get a character from the XML line.
                c = xmlLine.dequeue();
                // Ignore the open tag symbol.
                if (c == OPEN_TAG) {
                    foundOpenTag = false;
                    tagName = "";
                }
                // Looking for close tag symbol. And check if the tagStack is empty.
                if (c == CLOSE_TAG && !tagStack.isEmpty()) {
                    tagName = c + "";
                    // Check if the tag is an operation tag.
                    if (tagStack.peek() == QUESTION) {
                        while (!tagStack.isEmpty() && !foundOpenTag) {
                            if (tagStack.peek() == OPEN_TAG) {
                                foundOpenTag = true;
                            }
                            tagName = tagStack.pop() + tagName;
                        }
                        // Check the tag is correct.
                        if (!foundOpenTag || tagName.charAt(0) != OPEN_TAG
                                || tagName.charAt(1) != QUESTION
                                || tagName.charAt(tagName.length() - 2) != QUESTION
                                || tagName.charAt(tagName.length() - 1) != CLOSE_TAG) {
                            errorQueue.enqueue(new XMLTag(transTagName(tagName), lineNum));
                        }
                        // Check if the tag is a self-closing tag.
                    } else if (tagStack.peek() == SLASH) {
                        while (!tagStack.isEmpty() && !foundOpenTag) {
                            if (tagStack.peek() == OPEN_TAG) {
                                foundOpenTag = true;
                            }
                            tagName = tagStack.pop() + tagName;
                        }
                        if (!foundOpenTag || tagName.charAt(0) != OPEN_TAG
                                || tagName.charAt(tagName.length() - 2) != SLASH
                                || tagName.charAt(tagName.length() - 1) != CLOSE_TAG) {
                            errorQueue.enqueue(new XMLTag(transTagName(tagName), lineNum));
                        } else {
                            tagName = transTagName(tagName);
                            XMLTag tag = new XMLTag(tagName, lineNum);
                            tag.setSelfClosing(true);
                            checkParser(tag);
                        }
                        // Check if the tag is a normal tag.
                    } else {
                        while (!tagStack.isEmpty() && !foundOpenTag) {
                            if (tagStack.peek() == OPEN_TAG) {
                                foundOpenTag = true;
                            }
                            tagName = tagStack.pop() + tagName;
                        }
                        if (!foundOpenTag || tagName.charAt(0) != OPEN_TAG
                                || tagName.charAt(tagName.length() - 1) != CLOSE_TAG) {
                            errorQueue.enqueue(new XMLTag(transTagName(tagName), lineNum));
                        } else {
                            boolean isClosingTag = tagName.charAt(1) == SLASH;
                            tagName = transTagName(tagName);
                            XMLTag tag = new XMLTag(tagName, lineNum, isClosingTag);
                            checkParser(tag);
                        }
                    }
                }
                tagStack.push(c);
            }
            lineNum++;

        }
    }
    /**
     * This method is used to check if the tag is correct.
     *
     * pre-condition: The XML file must be existed and in the right format.
     * post-condition: The XML file will be parsed. If there is any error, it
     * will be stored in the error queue.
     *
     * @param tag The XML tag.
     */
    private void checkParser(XMLTag tag) {
        if (tag.isSelfClosing()) {
            return;
        }
        if (tag.isClosingTag()) {
            XMLTag topTag = tagsStack.peek();
            if (topTag.getTagName().equals(tag.getTagName())) {
                tagsStack.pop();
            } else if (!errorQueue.isEmpty() && tag.getTagName().equals(errorQueue.peek().getTagName())) {
                errorQueue.dequeue();
            } else if (tagsStack.isEmpty()) {
                errorQueue.enqueue(tag);
            } else {
                boolean found = false;
                int i = 0;
                Iterator<XMLTag> iterator = tagsStack.iterator();
                while (iterator.hasNext()) {
                    i++;
                    if (iterator.next().getTagName().equals(tag.getTagName())) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    // errorQueue.enqueue(tag); // not sure if need to enqueue it.
                    for (int j = 0; j < i; j++) {
                        errorQueue.enqueue(tagsStack.pop());
                    }
                } else {
                    extrasQueue.enqueue(tag);
                }
            }
        } else {
            tagsStack.push(tag);
        }
    }
    /**
     * This method is used to transform the tag name.
     *
     * pre-condition: The XML file must be existed and in the right format.
     * post-condition: The XML file will be parsed. If there is any error, it
     * will be stored in the error queue.
     *
     *
     * @return The transformed tag name.
     */
    private void checkError() {
        while (!tagsStack.isEmpty()) {
            errorQueue.enqueue(tagsStack.pop());
        }
        while (!extrasQueue.isEmpty() || !errorQueue.isEmpty()) {
            if (!extrasQueue.isEmpty() && !errorQueue.isEmpty()) {
                if (extrasQueue.peek().getTagName().equals(errorQueue.peek().getTagName())) {
                    extrasQueue.dequeue();
                    errorQueue.dequeue();
                } else {
                    reportError(errorQueue);
                }
            }
            if (!errorQueue.isEmpty() && extrasQueue.isEmpty()) {
                reportError(errorQueue);
            }
            if (!extrasQueue.isEmpty() && errorQueue.isEmpty()) {
                reportError(extrasQueue);
            }
        }
    }

    /**
     * This method is used to report the error.
     * @param queue The queue that contains the error.
     */
    private void reportError(MyQueue<XMLTag> queue) {
        this.isError = true;
        while (!queue.isEmpty()) {
            XMLTag tag = queue.dequeue();
            System.out.println("Error at line " + tag.getLineNum() + ": " + tag.getTagName());
        }
    }

    public MyQueue<MyQueue<Character>> getXmlLines() {
        return xmlLines;
    }

    public MyStack<XMLTag> getTagsStack() {
        return tagsStack;
    }

    public MyQueue<XMLTag> getErrorQueue() {
        return errorQueue;
    }

    /**
     * This method is used to transform the tag name.
     * @param tagName The tag name.
     *
     * @return  the transformed tag name.
     */
    private String transTagName(String tagName) {
        if (tagName.length() <= 1) {
            return tagName;
        }
        if (tagName.charAt(1) == SLASH) {
            tagName = tagName.substring(1);
        }
        if (tagName.charAt(tagName.length() - 2) == SLASH) {
            tagName = tagName.substring(0, tagName.length() - 1);
        }
        if (tagName.contains(" ")) {
            return tagName = tagName.substring(1, tagName.indexOf(SPACE));
        } else {
            return tagName = tagName.substring(1, tagName.length() - 1);
        }
    }
}
