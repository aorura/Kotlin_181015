package ex8

// enum { RED, ORANGE }
// enum은 객체를 만듭니다.

// 1. enum keyword: soft keyword 입니다.
//  => class 라는 키워드랑 같이 사용할때만 키워드로 취급됩니다.

// 2. 프로퍼티나 메소드를 가질 수 있는 객체 입니다.
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    INDIGO(75, 0, 130);

    // 메소드를 정의하기 위해서는 ; 을 써야 합니다.
    fun rgb(): Int {
        return (r * 256 + g) * 256 + b
    }

}

fun main(args: Array<String>) {
    println(Color.RED)
    println(Color.RED.r)
    println(Color.RED.rgb())
}








