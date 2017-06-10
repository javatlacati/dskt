package katlin.lists

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Created by Administrador on 10/06/2017.
 */
@RunWith(Parameterized::class)
class MyListTest(var myInterface: MyList) {

    @Test
    @Throws(Exception::class)
    fun size() {
        assertNotNull(myInterface.size())
        assertEquals(0, myInterface.size().toLong())
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun instancesToTest(): List<Array<out Any>> {
            return listOf(
                    arrayOf(katlin.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList())
                    ,arrayOf<Any>(katlin.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList())
            )
        }
    }

}