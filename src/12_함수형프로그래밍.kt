// Kotlin = OOP + FP

// 함수형 프로그래밍
//  => 함수를 일급 시민(First-class citizen)으로 취급해야 한다.
//  1) 변수(variable)에 담을 수 있다.
//  2) 인자(parameter)에 전달할 수 있다.
//  3) 반환 값(return value)에 전달할 수 있다.
//  4) 실행 시간(runtime)에 생성이 가능하다.
//  5) 익명(anonymous)으로 생성이 가능해야 한다.

/*
fun add(a: Int, b: Int): Int {
    return a + b
}
*/


// 1. 단일 표현식 함수: 반환 타입 추론이 가능합니다.
// var n                   = 42
fun add(a: Int, b: Int): Long = (a + b).toLong()

fun mul(a: Int, b: Int) = a * b
fun sub(a: Int, b: Int) = a - b


// 2. 함수의 타입은 함수의 시그니쳐(Signature)에 의해서 결정된다.
//  함수의 시그니쳐: 인자의 타입과 개수, 반환 타입에 대한 정보

// KFunction2<Arg1, Arg2, Ret>
//  : IDE에서 추론하는 타입은 JVM에서 취급되는 타입이다.
//  실제 타입은 (Int, Int) -> Long
/*
fun main(args: Array<String>) {

    // 3. 함수를 변수에 담을 수 있다.
    val fp1 = ::add
    // val fp2: KFunction2<Int, Int, Int> = ::sub
    val fp2: (Int, Int) -> Long = ::add
    val fp3: (Int, Int) -> Int = ::sub

    var fp: (Int, Int) -> Int
    fp = ::sub
    println(fp(10, 20))

    fp = ::mul
    println(fp(10, 20))
}
*/


/*
fun printArea(width: Int, height: Int) {
    // 4. 지역 함수를 만드는 것도 가능합니다.
    fun calculateArea(width: Int, height: Int) = width * height

    val area = calculateArea(width, height)
    println("The area is $area")
}
*/

fun printArea(width: Int, height: Int) {

    // 5. 지역함수에서는 클로져도 사용할 수 있습니다.
    // Closure: 외부 스코프에 선언된 매개변수나 변수에 접근하는 것이 가능합니다.
    fun calculateArea() = width * height

    val area = calculateArea()
    println("The area is $area")
}

fun main(args: Array<String>) {
    printArea(10, 40)
}














