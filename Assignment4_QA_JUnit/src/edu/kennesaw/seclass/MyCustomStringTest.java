/* Name: Ian Chorne
 * Class/Section: SWE 3643/02
 * Date: 4/12/2023
 * Assignment 4
 */

package edu.kennesaw.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import java.lang.MyIndexOutOfBoundsException;

import static org.junit.Assert.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    /**
     * This is the given test case. I have not modified it. It tests a long string with spaces, special characters and some numbers*/
    @Test
    public void testCountNumbers_1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }


    /** countNumbers 2
     * Tests the null pointer exception
     * */
    @Test(expected = NullPointerException.class)
    public void testCountNumbers_2() {
        mycustomstring.setString(null);
        assertEquals(NullPointerException.class, mycustomstring.countNumbers());
    }

    /** countNumbers 3
     * Tests a string with no numbers
     * */
    @Test
    public void testCountNumbers_3() {
        mycustomstring.setString("Hello world!");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /** countNumbers 4
     * Tests a string with only special characters
     * */
    @Test
    public void testCountNumbers_4() {
        mycustomstring.setString("!@#$%^&*()_+");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /** countNumbers 5
     * Tests a string with a mix of special characters, letters, and numbers
     * */
    @Test
    public void testCountNumbers_5() {
        mycustomstring.setString("M!x0fNums@ndCh4rs");
        assertEquals(2, mycustomstring.countNumbers());
    }

    /** countNumbers 6
     * Tests a string with spaces
     * */
    @Test
    public void testCountNumbers_6() {
        mycustomstring.setString(" 1 2 3 4 5 ");
        assertEquals(5, mycustomstring.countNumbers());
    }

    /** countNumbers 7
     * Tests an empty string
     * */
    @Test
    public void testCountNumbers_7() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /** countNumbers 8
     * Tests a string with only one number
     * */
    @Test
    public void testCountNumbers_8() {
        mycustomstring.setString("420");
        assertEquals(1, mycustomstring.countNumbers());
    }

    /** countNumbers 9
     * Tests a string with only spaces
     * */
    @Test
    public void testCountNumbers_9() {
        mycustomstring.setString("     ");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /** getEveryNthCharacterFromBeginningOrEnd 1
     * Testing from n onwards, from the beginning*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_1(){
        mycustomstring.setString("This is the test string");
        assertEquals("This is the test string", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 2
     * Testing from n2 onwards, from the end*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_2(){
        mycustomstring.setString("ThisIsTheTestString");
        assertEquals("nrSsThssh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 3
     * Testing illegal argument exception by making n <= 0*/
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd_3(){
        mycustomstring.setString("This is the test string");
        assertEquals(IllegalArgumentException.class, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 4
     * Testing null pointer exception */
    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd_4(){
        mycustomstring.setString(null);
        assertEquals(NullPointerException.class, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 5
     * Testing whether the method can return an empty string if startFromEnd is true*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_5(){
        mycustomstring.setString("String");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(7, true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 6
     * Testing whether the method can return an empty string if startFromEnd is false*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_6(){
        mycustomstring.setString("String");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(8, false));

    }

    /** getEveryNthCharacterFromBeginningOrEnd 7
     * Testing a valid input where n is 1 and startFromEnd is true. Main goal is testing the functionality of StartFromEnd*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_7(){
        mycustomstring.setString("String");
        assertEquals("gnirtS", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 8
     * Testing a valid input where n is the length of the input string and startFromEnd is true
     * We expect H because the method iterates over the string from end to beginning, and returns the final character in the string's length*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_8(){
        String testString = "Hello";
        mycustomstring.setString(testString);
        assertEquals("H", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(testString.length(), true));
    }

    /** getEveryNthCharacterFromBeginningOrEnd 9
     * Testing a valid input where n is the length of the input string and startFromEnd is false
     * We expect 0 because the method iterates over the string from beginning to end, and returns the final character in the string's length*/
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd_9(){
        String testString = "Hello";
        mycustomstring.setString(testString);
        assertEquals("o", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(testString.length(), false));
    }

    /*** convertDigitsToNamesInSubstring 1
     * Testing a valid input with all digits included
     */
    @Test
    public void testConvertDigitsToNamesInSubstring_1(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("FourTwoZero", mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 2
     * Testing a valid input with only second digit included
     */
    @Test
    public void testConvertDigitsToNamesInSubstring_2(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(2, 2);
        assertEquals("4Two0", mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 3
     * Testing invalid input. Start > end
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring_3(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(3, 2);
        assertEquals(IllegalArgumentException.class, mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 4
     * Testing invalid input. Start < string length
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring_4(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(0, 2);
        assertEquals(MyIndexOutOfBoundsException.class, mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 5
     * Testing invalid input. End > string length
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring_5(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(1, 4);
        assertEquals(MyIndexOutOfBoundsException.class, mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 6
     * Testing invalid input. End and start < string length
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring_6(){
        String testString = "420";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(-1, 0);
        assertEquals(MyIndexOutOfBoundsException.class, mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 7
     * Testing invalid input. String is null
     */
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring_7(){
        String testString = null;
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals(NullPointerException.class, mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 8
     * Testing valid input. String has letters
     */
    @Test
    public void testConvertDigitsToNamesInSubstring_8(){
        String testString = "aBc123DeF";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(1, 9);
        assertEquals("aBcOneTwoThreeDeF", mycustomstring.getString());
    }

    /*** convertDigitsToNamesInSubstring 9
     * Testing valid input. String has special characters
     */
    @Test
    public void testConvertDigitsToNamesInSubstring_9(){
        String testString = "!@#123$6";
        mycustomstring.setString(testString);
        mycustomstring.convertDigitsToNamesInSubstring(1, 8);
        assertEquals("!@#OneTwoThree$Six", mycustomstring.getString());
    }

}
