package katlin.linkedlists.singlelinkedlists

import junit.framework.Assert.assertNotNull
import org.junit.Test

/**
 * Created by Administrador on 24/05/2017.
 */
class JosephusProblemTest {
    @Test
    fun getSurvivor() {
        val josephusProblem = JosephusProblem(10, 3)
        val survivor = josephusProblem.survivor
        println(survivor)
        assertNotNull(survivor)
    }

}