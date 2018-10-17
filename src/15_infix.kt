package ex15

// Infix Function: 중위 함수
// fun pair(key: Any, value: Any) = Pair(key, value)

infix fun Any.pair(value: Any) = Pair(this, value)
// 인자가 하나뿐인 함수에 대해서 중위 함수를 만들 수 있습니다.

fun main(args: Array<String>) {
    // val pair1 = pair("name", "Tom")
    // val pair2 = pair("age", 42)

    val pair5 = "name" to "Tom"

    val pair1 = "name".pair("Tom")
    val pair2 = "age".pair(42)

    val pair3 = "name" pair "Tom"
    val pair4 = "age" pair 42
}