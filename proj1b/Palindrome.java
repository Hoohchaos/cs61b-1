/**
 * Tip: Search the web to see how to get the ith character in a String.
 * Tip: Inserting chars into a Deque<Character> is just like inserting ints into a LinkedListDeque<Integer>.
 * Tip: I do not recommend writing JUnit tests for wordToDeque. Instead, use the printDeque method to make sure
 * things look correct.
 * Tip: Consider recursion. It's a more beautiful approach to this problem IMO.
 * Just for fun: Uncomment the main method in the provided PalindromeFinder.java class and you'll get a list of
 * all palindromes of length 4 or more in English (assuming you also downloaded the provided words file).
 */
public class Palindrome implements CharacterComparator {

    // The wordToDeque method should be straightforward. You will simply build a Deque where the characters in the deque
    // appear in the same order as in the word.

    public static Deque<Character> wordToDeque(String word){
        Deque<Character> wordInDeque = new ArrayDequeSolution<>();
        for(int i = 0; i < word.length(); i++){
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }


    //The isPalindrome method should return true if the given word is a palindrome, and false otherwise.
    // A palindrome is defined as a word that is the same whether it is read forwards or backwards.
    // For example "a", "racecar", and "noon" are all palindromes. "horse", "rancor", and "aaaaab" are not palindromes.
    // Any word of length 1 or 0 is a palindrome.
    // 'A' and 'a' should not be considered equal. You don't need to do anything special for capital letters to work
    // properly. In fact, if you forgot that they exist, your code will work fine.

    public static boolean isPalindrome(String word){
        if(word.length() == 1 || word.length() == 0 ){
            return true;
        }else{
            return reverseString(word).equals(word);
        }
    }



    //The method will return true if the word is a palindrome according to the character comparison test
    // provided by the CharacterComparator passed in as argument cc. A character comparator is defined as
    // shown below:


//    /** This interface defines a method for determining equality of characters. */
//    public interface CharacterComparator {
//        /** Returns true if characters are equal by the rules of the implementing class. */
//        boolean equalChars(char x, char y);
//    }

    @Override
    public boolean equalChars(char x, char y) {
        return x == y;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        boolean isEqual = false;
        for(int i = 0, j = word.length() - 1; i < word.length()/2; i++,j--){
           if(cc.equalChars(word.charAt(i),word.charAt(j)) == false) {
              isEqual = false;
           }else{
              isEqual = true;
           }

        }
        return isEqual;

    }





    private static String reverseString(String str){
        if(str.length() == 1){
            return str;
        }else{
            String reversed = reverseString(str.substring(1)) + str.charAt(0);
            return reversed;
        }

    }

    public static void main(String[] args){
        CharacterComparator cc = new Palindrome();
        wordToDeque("morning");
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("aaa"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("great", cc));
    }
}
