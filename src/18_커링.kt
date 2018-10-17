package ex19

import java.lang.Appendable
import java.time.LocalDateTime

// Currying(커링)
//  : 다중 인수를 갖는 함수를 단일 인수를 갖는 함수열로 바꾸는 작업

// 1) 함수의 실행을 지연할 수 있습니다.

// fun sum(x: Int)(y: Int) = x + y
fun sum(x: Int, y: Int): Int = x + y
//    sum(10, 20) => 30
// :  sum(10)(20) => 30

//fun sum(x: Int): (Int) -> Int = { y ->
//    x + y
//}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = { p1 ->
    { p2 ->
        this(p1, p2)
    }
}


// sum(10): (Int) -> Int
// sum(10)(20) -> 30
/*
fun main(args: Array<String>) {
//    val r1: (Int) -> Int = sum(10)
//    val result = r1(20)
//    println(result)

    val csum = ::sum.curried()
    val result = csum(10)(20)
    println(result)

//    val result = sum(10, 20)
//    println(result)
}
*/

// 인자가 3개인 함수를 curring 하기
fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R = { p1 ->
    { p2 ->
        { p3 ->
            this(p1, p2, p3)
        }
    }
}

// 현재 사용하고 있는 라이브러리의 로깅 함수
enum class Level { INFO, WARN, ERROR, CRITICAL }

fun log(level: Level, appendable: Appendable, message: String) {
    appendable.appendln("[${level.name}][${LocalDateTime.now()}]: $message")
}

// 다른 라이브러리
fun processing(logger: (String) -> Unit) {
    logger("processing start")

    logger("processing...")

    logger("processing finished")
}

// 2) 커링 목적: 부분 적용
//   : 함수의 인자를 특정한 값으로 고정한다.
//     더 적은 인자를 가지는 함수의 시그니쳐에 맞춘다.
fun main(args: Array<String>) {
    // log(Level.INFO, System.out, "Program start")

    val log = ::log.curried()(Level.INFO)(System.out)
    processing(log)
    processing(log)
    processing(log)

    /*
    processing { message ->
        log(Level.ERROR, System.err, message)
    }

    processing { message ->
        log(Level.INFO, System.err, message)
    }

    processing { message ->
        log(Level.INFO, System.err, message)
    }
    */
}

// Refactoring(마틴 파울러) 2판
// 1판: Java
// 2판: Javascript
//     함수형 사고









