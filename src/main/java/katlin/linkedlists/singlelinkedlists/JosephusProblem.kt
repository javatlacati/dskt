package katlin.linkedlists.singlelinkedlists

/**
 * Created by Administrador on 24/05/2017.
 */
class JosephusProblem(internal val romanSoldiersNumber: Int, internal val iteration: Int) {

    internal val survivor: Node
        get() {
            val tail = Node(1)
            var survivor = tail
            for (i in 0..romanSoldiersNumber - 1) {
                survivor.next = Node(i)
                survivor = survivor.next!!
            }
            survivor.next = tail
            while (survivor != survivor.next) {
                for (i in 0..iteration - 1) {
                    survivor = survivor.next!!
                    survivor.next = survivor.next!!.next
                }
            }
            return survivor
        }
}