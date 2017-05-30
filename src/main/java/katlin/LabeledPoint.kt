package katlin

class LabeledPoint(override var y: Double, override var x: Double, var label: String) : Point() {

    override fun toString(): String {
        return "$label${super.toString()}"
    }
}