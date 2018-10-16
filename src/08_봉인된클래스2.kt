package ex8

import java.lang.IllegalArgumentException


// 문제점: 새로운 Expr 기반의 클래스가 생성될 경우, 예외가 발생한다.
// 해결 방법: Num, Sum 이외의 Expr 기반의 하위 클래스 생성을 방어할 수 있다.
//  => 봉인된 클래스: 계층을 아무나 확장하는 것을 방어한다.

/*
interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
    return when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }
}
*/

// sealed class: open 되어 있다.
//   '중첩 클래스'에서만 상속하는 것을 허용한다. - 1.0
//    같은 파일에서는 허용한다.             - 1.1
sealed class Expr {
//    class Num(val value: Int) : Expr()
//    class Sum(val left: Expr, val right: Expr) : Expr()
}

class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
    }
}

















