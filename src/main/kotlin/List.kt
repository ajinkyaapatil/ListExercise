
fun <T> llistOf(vararg elements: T): ListType<T> {

    tailrec fun loop(list: ListType<T>, pos: Int): ListType<T> {
        return if (elements.size == pos) list
        else loop(list.insert(elements[pos]), pos + 1)
    }

    return when (elements.isEmpty()) {
        true -> EmptyList()
        false -> loop(EmptyList(), 0)
    }

}

sealed class ListType<T> {

    fun insert(value: T): List<T> = when (this) {
        is EmptyList -> List(value)
        is List -> List(this.value, nextNode.insert(value))
    }

    fun size(): Int {
        fun loop(remainingList: ListType<T>): Int = when (remainingList) {
            is EmptyList -> 0
            is List -> loop(remainingList.next()) + 1
        }
        return loop(this)
    }

    fun get(pos: Int): T? {
        tailrec fun loop(currentPosition: Int, remainingList: ListType<T>): T? {
            if (currentPosition == 0 && remainingList is List) return remainingList.value
            return when (remainingList) {
                is EmptyList -> null
                is List -> loop(currentPosition - 1, remainingList.next())
            }
        }
        return loop(pos, this)
    }

    fun <U> foldLeft(accumulator: U, fn: (U, T) -> U): U {
        tailrec fun loop(acc: U, remainingList: ListType<T>): U = when (remainingList) {
            is EmptyList -> acc
            is List -> loop(fn(acc, remainingList.value), remainingList.next())
        }
        return loop(accumulator, this)
    }

    // TODO : implement using reverse and tailrec
    private fun <U> foldRight(accumulator: U, fn: (U, T) -> U): U {
        fun loop(acc: U, remainingList: ListType<T>): U = when (remainingList) {
            is EmptyList -> acc
            is List -> fn(loop(acc, remainingList.next()), remainingList.value)
        }
        return loop(accumulator, this)
    }

    fun forEach(predicate: (T) -> Unit) = foldLeft(Unit) { _, b -> predicate(b) }

    fun concat(other: ListType<T>): ListType<T> {
        return this.foldRight(other) { a, b -> List(b, a) }
    }

    fun <U> map(predicate: (T) -> U): ListType<U> = foldLeft(llistOf()) { acc, el ->
        acc.insert(predicate(el))
    }

    fun filter(predicate: (T) -> Boolean): ListType<T> = foldLeft(llistOf()) { acc, element ->
        when {
            predicate(element) -> acc.insert(element)
            else -> acc
        }
    }

    fun printList() {
        when (this) {
            is EmptyList -> print("null")
            is List -> {
                print("${this.value} -> ")
                next().printList()
            }
        }
    }

    override fun equals(other: Any?) = this.toString() == other.toString()

    fun repeatValues(): ListType<T> =
        foldLeft(llistOf<ListType<T>>())
        { a, b ->
            a.insert((0 until b as Int)
                .fold(llistOf()) { acc, _ ->
                    acc.insert(b)
                })
        }.flatten()

}

fun <T> ListType<ListType<T>>.flatten(): ListType<T> =
    foldLeft(llistOf()) { acc, b -> acc.concat(b) }

data class List<T>(val value: T, val nextNode: ListType<T> = EmptyList()) : ListType<T>() {
    fun next() = nextNode
}

class EmptyList<T> : ListType<T>() {
    override fun hashCode(): Int {
        return 0
    }
}

fun main() {
    val l = llistOf(llistOf(1, 2), llistOf(3, 4))
    val b = llistOf(6, 7)
    val c = llistOf(1, 2)
    l.flatten().printList()
}
