// 프로퍼티도 확장하는 것이 가능합니다.
//  : 'Backing Field'가 없는 프로퍼티

// val: getter
// var: getter + setter
val String.lastChar: Char
    get() = get(length - 1)

// String은 Immutable Object 입니다.
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) = setCharAt(length - 1, value)

fun main(args: Array<String>) {
    println("Hello".lastChar)

    val sb = StringBuilder("Hello?")
    println(sb.toString())

    sb.lastChar = '!'
    println(sb.toString())
}








