package ex163

// 함수를 반환하는 함수
//  => 실행 시간에 함수를 만드는 기술

/*
fun foo(): (String) -> String {
    return { str ->
        str.reversed()
    }
}

fun foo(): (String) -> String = { str ->
    str.reversed()
}


fun main(args: Array<String>) {
    // 실행 시간에 함수를 만들었다.
    val reverse: (String) -> String = foo()

    val str = "hello"
    println(reverse(str))
}
*/

fun modulo(k: Int, r: Int): (Int) -> Boolean = { value: Int ->
    value % k == r
}

/*
// 함수를 실행 시간에 생성하는 기술
fun isEven(value: Int) = value % 2 == 0
fun isOdd(value: Int) = value % 2 == 1
*/

fun main(args: Array<String>) {
    val data = listOf(1, 2, 3, 4, 5)

//    val isEven = modulo(2, 0)
//    val isOdd = modulo(2, 1)

    println(data.filter(modulo(2, 0)))
}







