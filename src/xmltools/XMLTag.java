package xmltools;

/**
 * Class description: This class holds the information for a single XML tag.
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 */
public class XMLTag {
    /**
     * The name of the tag.
     */
    private String tagName;

    /**
     * The line number of the tag in the XML file.
     */
    private int lineNum;

    /**
     * If the tag is closed or open.
     */
    private boolean isClosingTag;

    /**
     * If the tag is a self-closing tag.
     */
    private boolean selfClosing;

    /**
     * Constructor for open XMLTag
     *
     * @param tagName
     */
    public XMLTag(String tagName, int lineNum) {
        this.tagName = tagName;
        this.lineNum = lineNum;
        this.isClosingTag = false;
        this.selfClosing = false;
    }

    /**
     * Constructor for XMLTag
     *
     * @param tagName
     * @param isClosingTag
     */
    public XMLTag(String tagName, int lineNum, boolean isClosingTag) {
        this.tagName = tagName;
        this.lineNum = lineNum;
        this.isClosingTag = isClosingTag;
        this.selfClosing = false;
    }

    /**
     * @return Get the tag name.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName Set the tag name.
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return If this is a closing tag return true, otherwise return false.
     */
    public boolean isClosingTag() {
        return isClosingTag;
    }

    /**
     * @param closingTag Set the tag is closing or not.
     */
    public void setClosingTag(boolean closingTag) {
        isClosingTag = closingTag;
    }

    /**
     * @return Return true if the tag is self-closing, otherwise return false.
     */
    public boolean isSelfClosing() {
        return selfClosing;
    }

    /**
     * @param selfClosing Set the tag is self-closing or not.
     */
    public void setSelfClosing(boolean selfClosing) {
        this.selfClosing = selfClosing;
    }

    /**
     * @return Get the tag's line number.
     */
    public int getLineNum() {
        return lineNum;
    }

    /**
     * @param lineNum Set the tag's line number.
     */
    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }
}
