import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BaseListTest {
    @Test
    fun `should return null if list is empty`() {
        val list = llistOf<Int>()
        assertNull(list.get(0))
    }

    @Test
    fun `should return Node if the list provided has value`() {
        val list = llistOf(1)
        assertEquals(1, list.get(0))
    }

    @Test
    fun `should return Nodes for all the value passed`() {
        val list = llistOf(1, 2)
        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
    }

    @Test
    fun `should return size of the list`() {
        val list = llistOf(1, 2, 3)
        assertEquals(3, list.size())
    }

    @Test
    fun `should concat two or more list`() {
        val list1 = llistOf(1, 2)
        val list2 = llistOf(3, 4)
        assertEquals(llistOf(1, 2, 3, 4), list1.concat(list2))
    }
}