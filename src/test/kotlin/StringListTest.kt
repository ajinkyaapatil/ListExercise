
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringListTest {
    @Test
    fun `should return upper case values given list of String`() {
        val stringList = llistOf("I", "AM", "A", "Boy")
        val upperCaseList = stringList.getUpperCaseString()
        assertEquals(llistOf("I", "AM", "A"), upperCaseList)
    }

    @Test
    fun `should return lower case values given list of String`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val lowerCaseList = stringList.lowerCaseString
        assertEquals(llistOf("am"), lowerCaseList)
    }

    @Test
    fun `should return string with length as three`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val stringWithLengthThree = stringList.withLength(3)
        assertEquals(llistOf("Boy"), stringWithLengthThree)
    }

    @Test
    fun `should return length of the strings given list of string`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val integerListOfLength = stringList.getStringLengths()
        assertEquals(llistOf(1, 2, 1, 3), integerListOfLength)
    }

    @Test
    fun `should return sum of all length of Strings given list of Strings`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val sumOfStringLengths = stringList.sumOfStringLengths()
        assertEquals(7, sumOfStringLengths)
    }

    @Test
    fun `should return concat of all the string with seperator`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val concatString = stringList.concatStringsWith(" ")
        assertEquals("I am A Boy ", concatString)
    }

    @Test
    fun `should return string with first character of all string`() {
        val stringList = llistOf("I", "am", "A", "Boy")
        val firstLetterOfStrings = stringList.getFirstCharacters()
        assertEquals("IaAB", firstLetterOfStrings)
    }
}