package katlin.adt

class LabeledPoint(override var y: Double, override var x: Double, var label: String) : Point() {

    /**Returns a string representation of the object. */
    override fun toString(): String {
        return "$label${super.toString()}"
    }
}