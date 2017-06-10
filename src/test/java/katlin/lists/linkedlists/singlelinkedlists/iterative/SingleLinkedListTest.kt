package katlin.lists.linkedlists.singlelinkedlists.iterative

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Core i7 on 31/05/2017.
 */
class SingleLinkedListTest  {
    internal var instance: SingleLinkedList? = null
    @Before
    @Throws(Exception::class)
    fun setUp() {
        instance = SingleLinkedList()
    }

    @Test
    @Throws(Exception::class)
    fun getStrings() {
        instance!!.addAtEnd(Node("Adios"))
        instance!!.addAtEnd(Node("mundo"))
        instance!!.addAtEnd(Node("cruel"))
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance!!.strings)
    }

    @Test
    @Throws(Exception::class)
    fun equalstest() {
    }

    @Test
    @Throws(Exception::class)
    fun hashCodetest() {
    }

    @Test
    @Throws(Exception::class)
    fun canEqual() {
    }

    @Test
    @Throws(Exception::class)
    fun getRoot() {
        val instance = SingleLinkedList()
        assertNull(instance.root)
    }

    @Test
    @Throws(Exception::class)
    fun setRoot() {
        instance!!.root = Node(3)
        assertNotNull(instance!!.root)
    }
}