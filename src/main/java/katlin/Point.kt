package katlin

//class Point(var y: Double, var x: Double) {
//
//}

//class Point {
//    var y: Double
//    var x: Double
//
//    constructor(y: Double, x: Double) {
//        this.y = y
//        this.x = x
//    }
//
//    constructor() {
//        x = Math.random()
//        y = Math.random()
//    }
//
//    override fun toString(): String {
//        return "($x, $y)"
//    }
//}

//class Point {
//    var y: Double
//    var x: Double
//
//    constructor() {
//        x = Math.random()
//        y = Math.random()
//    }
//
//    constructor(y: Double, x: Double) {
//        this.y = y
//        this.x = x
//    }
//
//    internal fun r(): Double {
//        return Math.sqrt(x * x + y * y)
//    }
//
//    internal fun theta(): Double {
//        return Math.atan2(x, y)
//    }
//
//    internal fun distance(point: Point): Double {
//        val dx = x - point.x
//        val dy = y - point.y
//        return Math.sqrt(dx * dx + dy * dy)
//    }
//
//    override fun toString(): String {
//        return "($x, $y)"
//    }
//}

//open class Point {
//    var y: Double
//    var x: Double
//
//    constructor() {
//        x = Math.random()
//        y = Math.random()
//    }
//
//    constructor(y: Double, x: Double) {
//        this.y = y
//        this.x = x
//    }
//
//    internal fun r(): Double {
//        return Math.sqrt(x * x + y * y)
//    }
//
//    internal fun theta(): Double {
//        return Math.atan2(x, y)
//    }
//
//    internal fun distance(point: Point): Double {
//        val dx = x - point.x
//        val dy = y - point.y
//        return Math.sqrt(dx * dx + dy * dy)
//    }
//
//    override fun toString(): String {
//        return "($x, $y)"
//    }
//}

open class Point {
    open var y: Double
    open var x: Double

    constructor() {
        x = Math.random()
        y = Math.random()
    }

    constructor(y: Double, x: Double) {
        this.y = y
        this.x = x
    }

    internal fun r(): Double {
        return Math.sqrt(x * x + y * y)
    }

    internal fun theta(): Double {
        return Math.atan2(x, y)
    }

    internal fun distance(point: Point): Double {
        val dx = x - point.x
        val dy = y - point.y
        return Math.sqrt(dx * dx + dy * dy)
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}