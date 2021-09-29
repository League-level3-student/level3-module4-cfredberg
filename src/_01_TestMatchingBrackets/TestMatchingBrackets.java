package _01_TestMatchingBrackets;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	int openCount = 0;
    	int closeCount = 0;
    	char firstChar = b.toCharArray()[0];
    	char lastChar = b.toCharArray()[b.length()-1];
    	for (char chr : b.toCharArray()) {
    		if (chr == '{') {
    			openCount++;
    		}else {
    			closeCount++;
    		}
    	}
    	if (openCount == closeCount) {
    		if (firstChar == '{' && lastChar == '}') {
    			return true;
    		}
    	}
    	
        return false;
    }
}