
val ListType<String>.lowerCaseString get() = filter { it.all { chr -> chr.isLowerCase() } }

fun ListType<String>.getUpperCaseString(): ListType<String> =
    filter { it.all { chr -> chr.isUpperCase() } }

fun ListType<String>.withLength(len: Int): ListType<String> =
    filter { it.length == len }

fun ListType<String>.getStringLengths(): ListType<Int> =
    foldLeft(llistOf()) { acc, el -> acc.insert(el.length) }

fun ListType<String>.sumOfStringLengths(): Int =
    this.getStringLengths().foldLeft(0) { acc, el -> acc + el }

fun ListType<String>.concatStringsWith(separator: String) =
    foldLeft("") { acc, el -> acc + el + separator }

fun ListType<String>.getFirstCharacters() =
    foldLeft("") { acc, el -> acc + el.first() }