package khosravi.android.espashgar

import kotlin.random.Random

fun aBoolean(random: Random = Random): Boolean {
    return when ((0..1).random(random)) {
        1 -> true
        else -> false
    }
}

fun aString(length: Int = 5, maybeNumber: Boolean = true, random: Random = Random): String {
    require(length > -1) {
        "length must bigger than -1"
    }
    var allowedChars = ('A'..'Z') + ('a'..'z')
    if (maybeNumber) {
        allowedChars = allowedChars.plus('0'..'9')
    }
    return (1..length)
        .map { allowedChars.random(random) }
        .joinToString("")
}

fun aHexColor(random: Random = Random): String {
    val nextInt = random.nextInt(0xffffff + 1)
    return String.format("#%06x", nextInt)
}

fun aInt(random: Random = Random) = random.nextInt(Int.MIN_VALUE, Int.MAX_VALUE)

fun aLong(random: Random = Random) = random.nextLong(Long.MIN_VALUE, Long.MAX_VALUE)

fun aPositiveInt(random: Random = Random) = random.nextInt(0, Int.MAX_VALUE)

fun aPositiveLong(random: Random = Random) = random.nextLong(0, Long.MAX_VALUE)