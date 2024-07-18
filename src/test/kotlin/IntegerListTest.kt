import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerListTest {
    @Test
    fun `should return square values for the value passed`() {
        val integerList = llistOf(1, 2, 3)
        val squareValues = integerList.toSquare()
        assertEquals(llistOf(1, 4, 9), squareValues)
    }

    @Test
    fun `should return cube values for the value passed`() {
        val integerList = llistOf(1, 2, 3)
        val cubeValues = integerList.toCube()
        assertEquals(llistOf(1, 8, 27), cubeValues)
    }

    @Test
    fun `should return odd values from the value passed`() {
        val integerList = llistOf(1, 2, 3)
        val oddValues = integerList.oddValues()
        assertEquals(llistOf(1, 3), oddValues)
    }

    @Test
    fun `should return even values from value passed`() {
        val integerList = llistOf(1, 2, 3)
        val evenValues = integerList.evenValues()
        assertEquals(llistOf(2), evenValues)
    }

    @Test
    fun `should return sum of all values of the values passed`() {
        val integerList = llistOf(1, 2, 3)
        val sum = integerList.sum()
        assertEquals(6, sum)
    }

    @Test
    fun `should return min value from the value passed`() {
        val integerList = llistOf(1, 2, 3)
        val min = integerList.minVal()
        assertEquals(1, min)
    }

    @Test
    fun `should return max value fom the value passed`() {
        val integerList = llistOf(1, 2, 3)
        val max = integerList.maxVal()
        assertEquals(3, max)
    }

    @Test
    fun `should return n repeating values of value passed`() {
        val integerList = llistOf(1, 2, 3)
        val repeatingValues = integerList.repeatValues()
        assertEquals(llistOf(1, 2, 2, 3, 3, 3), repeatingValues)
    }
}