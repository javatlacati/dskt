package katlin.linkedlists.singlelinkedlists

class Node(var item: Any?) {
    var next: Node? = null

    override fun equals(o: Any?): Boolean {
        if (o === this) return true
        if (o !is Node) return false
        val other = o
        if (!other.canEqual(this as Any)) return false
        val `this$item` = this.item
        val `other$item` = other.item
        if (if (`this$item` == null) `other$item` != null else `this$item` != `other$item`) return false
        return true
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$item` = this.item
        result = result * PRIME + (`$item`?.hashCode() ?: 43)
        return result
    }

    protected fun canEqual(other: Any): Boolean {
        return other is Node
    }

    override fun toString(): String {
        return "jaba.linkedlists.singlelinkedlists.Node(item=" + this.item + ")"
    }
}