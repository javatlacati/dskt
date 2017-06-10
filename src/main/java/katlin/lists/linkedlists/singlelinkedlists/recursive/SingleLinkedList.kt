package katlin.lists.linkedlists.singlelinkedlists.recursive

import katlin.lists.MyList

/**
 * Created by Core i7 on 30/05/2017.
 */
class SingleLinkedList: MyList {
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

    override fun size(): Int {
        if (root == null) {
            return 0
        } else
            return root!!.size(1)
    }
}