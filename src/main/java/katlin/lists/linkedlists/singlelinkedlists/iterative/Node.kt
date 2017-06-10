package katlin.lists.linkedlists.singlelinkedlists.iterative

/**
 * Created by Core i7 on 30/05/2017.
 */
class Node(var item: Any?) {
    var next: Node? = null

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Node) return false
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

    override fun toString(): String = "Node(item=${this.item})"
}