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
    INDIGO(75, 0, 130),
    BLACK(0, 0, 0);

    // 메소드를 정의하기 위해서는 ; 을 써야 합니다.
    fun rgb(): Int {
        return (r * 256 + g) * 256 + b
    }
}

// 3. 코틀린은 switch 문법이 존재하지 않습니다.
//    when으로 대체할 수 있습니다.
fun getName(color: Color): String {
    /*
    switch (color) {
       case Color.RED: return "RED"
       case Color.ORANGE: break;
    }
    */

    // 1) when은 expression(식) 입니다.
    // 2) break를 사용할 필요가 없습니다.
    return when (color) {
        Color.RED -> "RED"
        Color.ORANGE -> "ORANGE"
        Color.YELLOW -> "YELLOW"
        Color.GREEN -> "GREEN"
        Color.INDIGO -> "INDIGO"
        else -> "BLACK"
    }
}

fun getWarmth(color: Color): String {
    return when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN, Color.INDIGO -> "cold"
        else -> "none"
    }
}

// when 식의 인자로 상수 뿐 아니라 임의의 객체를 넣어서 비교할 수 있습니다.
fun mix(c1: Color, c2: Color): Color {
    val mixed = setOf(c1, c2)
    return when (mixed) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        else -> throw Exception("dirty color")
    }
}


fun main(args: Array<String>) {
    println(Color.RED)
    println(Color.RED.r)
    println(Color.RED.rgb())
}








