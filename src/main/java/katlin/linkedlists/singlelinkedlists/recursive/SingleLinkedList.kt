package katlin.linkedlists.singlelinkedlists.recursive

/**
 * Created by Core i7 on 30/05/2017.
 */
class SingleLinkedList {
    private var root: Node? = null

    fun addAtEnd(newNode: Node) {
        if (root == null) {
            root = newNode
        } else {
            root!!.add(newNode)
        }
    }

    internal val strings: String
        get() {
            return if (root == null) "" else root!!.strings
        }
}