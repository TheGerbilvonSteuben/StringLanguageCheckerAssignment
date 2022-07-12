import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * Represents a finite language.
 * @author Dr. Jody Paul
 * @author Jerret Stovall
 * @author Austin Gailey
 * @version 1.3.8/25/2020
 */
// Thanks to Nate Roberts for all his helpful advice.
@SuppressWarnings("serial")
public final class Language implements Iterable<String>, java.io.Serializable 
{
	
    /** The set of strings in this language, initially empty. */
    private Set<String> strings;

    /**
     * Create a language with no strings.
     */
    public Language() 
    {
         
    	strings = new TreeSet<>();
    	
    }//End Language

    /**
     * Indicates if this language has no strings.
     * @return true if the language is equivalent to the empty set;
     *         false otherwise
     */
    public boolean isEmpty() 
    {
        
        return strings.isEmpty();
        
    }//End isEmpty

    /**
     * Accesses the number of strings (cardinality) in this language.
     * @return the cardinality of the language
     */
    public int cardinality() 
    {
        
        return strings.size();
        
    }//End cardinality

    /**
     * Determines if a specified string is in this language.
     * @param candidate the string to check
     * @return true if the string is in the language,
     *         false if not in the language or the parameter is null
     */
    public boolean includes(final String candidate) 
    {
        
        return strings.contains(candidate);
        
    }//End includes

    /**
     * Ensures that this language includes the given string
     * (adds it if necessary).
     * @param memberString the string to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addString(final String memberString) 
    {
        
        return strings.add(memberString);
        
    }//End addString

    /**
     * Ensures that this language includes all of the strings
     * in the given parameter (adds any as necessary).
     * @param memberStrings the strings to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addAllStrings(final Collection<String> memberStrings) 
    {
        
        return strings.addAll(memberStrings);
        
    }//End addAllStrings

    /**
     * Provides an iterator over the strings in this language.
     * @return an iterator over the strings in this language in ascending order
     */
    public Iterator<String> iterator() 
    {
        
        return strings.iterator();
        
    }//End iterator

    /**
     * Creates a language that is the concatenation of this language
     * with another language.
     * @param language the language to be concatenated to this language
     * @return the concatenation of this language with the parameter language
     */
    public Language concatenate(final Language language) 
    {
    	
    	/**
    	 ****************************************************************************************
    	 *    Title: Language
    	 *    Author: Austin Gailey
    	 *    Date: 8/26/2020
    	 *    Code version: 1.3.1
    	 *    Availability: agailey96@gmail.com
    	 ****************************************************************************************
    	 *    The following block of code was written by Austin Gailey.
    	 * */
    	
    	// An empty set concatenated with another empty set results in a empty set so just return a new language object.
        if(this.isEmpty() && language.isEmpty()) return new Language();

        Language concatenatedLanguage = new Language();
        // A*B = The set of all strings that can be represented as the concatenation of two strings, x and y, where x must 
        // be an element of A and y must be an element of B. Nested for loops are used to accomplish this.
        // For each string in Language A:
        for(String stringA : strings)
        {
        	
        	// concatenate with every string from Language B:
            for(String stringB : language.strings)
            {
            	
            	// Add the concatenated string to the new Language.
                concatenatedLanguage.addString(stringA+stringB);
                
            }//End inner for
            
        }///End outer for
        
        // Return the newly concatenated Language.
    	return concatenatedLanguage;
        
    }//End concatenate

    /**
     * Determines whether two Languages are the same.
     * @return True if the two Languages have the same set of strings. False otherwise.
     */
    @Override
    public boolean equals(final Object obj) 
    {
    	
    	/**
    	 *      ****************************************************************************************
    	 *    Title: Language
    	 *    Author: Austin Gailey
    	 *    Date: 8/26/2020
    	 *    Code version: 1.3.1
    	 *    Availability: agailey96@gmail.com
    	 ****************************************************************************************
    	 *    Thanks to Austin Gailey for helping me with the following code. I knew I 
    	 *    could use the .equals method of the Tree Set but didn't know how to cast it correctly.
    	 * */
    	// Compare the hashCodes of the two sets of strings and return true if the sets contain the same elements.
    	return strings.equals(((Language)obj).strings);
        
    }//End equals
    
    /**
     * Return a unique hashCode.
     * @return A unique integer that is calculated from summing the hashCodes of each 
     * 				   element in the strings instance variable. The hashCode of null elements equal zero during summation.
     * */
    @Override
    public int hashCode() 
    {
        
    	//The TreeSet class comes with its own hashCode method.
        return strings.hashCode();
        
    }//End hashCode
}//End Language