/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 * Uses advanced search for keywords
 * </li></ul>
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie4
{
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     * the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if ((findKeyword(statement, "mother") >= 0) ||
                (findKeyword(statement, "father") >= 0) ||
                (findKeyword(statement, "brother") >= 0) ||
                (findKeyword(statement, "sister") >= 0))
        {
            response = "Tell me more about your family.";
        }
        else if (findKeyword(statement, "sport") >= 0)
        {
            response = "What sports do you enjoy.";
        }
        else if(findKeyword(statement, "spanish") >= 0)
        {
            response = "I didn't know you spoke another language."; 
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @param startPos
     * the character of the string to begin the
     * search at
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        // trim() removes white space before and after the letters of a string
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int index = phrase.indexOf(goal); 

        // Your code goes here - if the word "no" is inside statement, 
        //return index, and print "Why so negative"
        boolean front = false;
        boolean back = false;
        
        // write code that will test if the letter prior to goal is a space.

        while(index != -1)
        {
            // test if the character before is a letter
            // ACSCII value of 'a' = 97, value of 'z' = 122
            
            
            
            // Test is goal the first word, if so set front to true
            if(index == 0) // if the goal is the first word
            {
                front = true;
            }
            else
            {
            // if not, get the get the letter before goal
            String firstLetter = phrase.substring(index-1,index);
            
            if(firstLetter.equals(" "))
            {
                front = true;
            }
            
            //  is letter compareTo "a" (neg? or pos?) and
            if(firstLetter.compareTo("a") > 0)
            {
                // is letter compareTo "z" (neg? or pos?)
                if(firstLetter.compareTo("z") > 0)
                {
                    front = true;
                }
            }
            // if either is false, set front to false. 
            else
            {
                front = false; 
            }
            
        }
            
            
            // Test if goal the last word, if so set back to true
            if(index == phrase.length()-goal.length())
            back = true; 
            else
            {
            // if not, get the letter after goal
            int lastIndex = goal.length()+index;
            String lastLetter = phrase.substring(lastIndex,lastIndex+1);
            if(lastLetter.equals(" "))
            back = true;
            //  is letter compareTo "a" (neg? or pos?) and
            //  is letter compareTo "z" (neg? or pos?)
            if(lastLetter.compareTo("a") > 0)
            {
                if(lastLetter.compareTo("z") > 0)
                back = true;
            }
            
            
            //      if either is false, set front to false
            else
            back = false;
            
            // if front and back are true, return index
            
            if(front == true && back == true) // if(front && back)
            {
                return index;
            }
            
            index = phrase.indexOf(goal,index+1); 
        }
            //  else, return -1
        }
        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 8;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Wow.";
        }
        else if (whichResponse == 5)
        {
            response = "Really!";
        }
        else if (whichResponse == 6)
        {
            response = "Ok.";
        }
        else if (whichResponse == 7)
        {
            response = "Uh huh.";
        }

        return response;
    }

}