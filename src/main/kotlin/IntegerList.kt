import kotlin.math.max
import kotlin.math.min

fun ListType<Int>.toSquare(): ListType<Int> =
    foldLeft(llistOf()) { acc, element -> acc.insert(element * element) }

fun ListType<Int>.toCube(): ListType<Int> =
    foldLeft(llistOf()) { acc, element -> acc.insert(element * element * element) }

fun ListType<Int>.oddValues() = filter { (it) % 2 == 1 }

fun ListType<Int>.evenValues() = filter { it % 2 == 0 }

fun ListType<Int>.sum() = foldLeft(0) { a, b -> a + b }

fun ListType<Int>.minVal() = foldLeft(Int.MAX_VALUE) { a, b -> min(a, b) }

fun ListType<Int>.maxVal() = foldLeft(Int.MIN_VALUE) { a, b -> max(a, b) }