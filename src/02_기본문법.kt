import java.util.*

// 1. main 함수를 만드는 방법
// 2. 함수를 만드는 방법
//  fun 함수이름(파라미터 변수명: 타입): 반환타입 {}
//   Java: 전역 함수를 만들 수 없다.
//     Collections / Arrays / Objects
//  Kotlin: 전역 함수를 만들 수 있다.
//     별도의 파일에 전역 함수들로만 구성할 수 있다.

// 3. Kotlin = OOP + FP(함수형 프로그래밍)
//   순수 함수(pure function)
//    = f(x, y) => x + y + g++ -> X
//    : 함수의 입력값이 동일하면 항상 결과는 동일하다.
//    = f(x, y) => x + y => z

//  Java        Kotlin
//  void   ->    Unit
// Object  ->    Any

// 4. 타입 시스템
//   1) Java
//    - Primitive Type(Value Type)
//      int, double, char, float, byte
//      * Collection에 저장할 수 없다.
//      * 필드와 메소드를 가질 수 있다.
//
//    - Reference Type
//      Integer, Double, Char, Float, String

//  2) Kotlin
//    모든 것은 객체이다.
//    Int, Double, String, Char, Byte


fun main(args: Array<String>) {
    // println(println("hello"))
    val n: Int = 42
    val nl: Long = n.toLong()

}








