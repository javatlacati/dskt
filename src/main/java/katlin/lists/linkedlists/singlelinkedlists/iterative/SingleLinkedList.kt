package katlin.lists.linkedlists.singlelinkedlists.iterative

import katlin.lists.MyList

class SingleLinkedList: MyList {
    var root: Node? = null

    internal val strings: String
        get() {
            if (root == null) {
                return ""
            } else {
                var salida = root.toString()
                var actual = root
                while (actual?.next != null) {
                    actual = actual.next
                    salida += actual.toString()
                }
                return salida
            }
        }

    fun addAtEnd(newNode: Node) {
        if (root == null) {
            root = newNode
        } else {
            var actual = root
            while (actual?.next != null) {
                actual = actual.next
            }
            actual!!.next = newNode
        }
    }

    fun addAtRoot(newNode: Node) {
        newNode.next=root
        root = newNode
    }
    override fun size(): Int {
        var size = 0
        var currentNode: Node? = root
        while (currentNode != null) {
            currentNode = currentNode.next
            size++
        }
        return size
    }

}