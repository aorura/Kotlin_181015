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

//    강력한 타입 제약이 존재한다.
//    : '암묵적인 타입 변환'을 거의 허용하지 않습니다.

//  3) 변수를 만드는 방법
//     : 타입 추론을 이용해 변수를 만듭니다.
//     var: 변수(var, let)
//       User user = new User();
//       var user = User()
//     val: 상수(let, const)
//       final User user = new User()
//       val user = User()
//    * 암묵적인 타입 지정
//     val user = new User()
//    * 명시적인 타입 지정
//     val user: User = new User()

// Statement(문) vs Expression(식)
// 문: 결과가 존재하지 않습니다.
// 식: 결과가 존재합니다.

fun main(args: Array<String>) {
    val n: Int = 42
    val nl: Long = n.toLong()

    val scanner = Scanner(System.`in`)
    val input = scanner.nextInt()

    /*
    var result: String
    if (input % 2 == 0) {
        result = "짝"
    } else {
        result = "홀"
    }
    */
    val result = if (input % 2 == 0) {
        "짝"
    } else {
        "홀"
    }

    /*
    var p: Int? = null
    if (p != null) {
        p.toLong()
    }
    */

    // println(println("hello"))
    /*
    val n: Int = 42
    val nl: Long = n.toLong()
    */
}








