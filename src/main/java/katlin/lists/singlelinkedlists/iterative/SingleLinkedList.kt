package katlin.lists.singlelinkedlists.iterative

class SingleLinkedList {
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
}