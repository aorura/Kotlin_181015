package ex162

// 동작 파라미터화
//  : 인터페이스 기반 설계
//  => 기존 자바에서는 함수를 전달할 수 없었다.

// 2) Kotlin - Function 기반의 전략 전달

fun filter(data: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()
    for (e in data) {
        // if (e % 2 == 0)
        if (predicate(e))
            result.add(e)
    }

    return result
}

fun isEven(e: Int) = e % 2 == 0
fun isOdd(e: Int) = e % 2 == 1

fun filterEven(data: List<Int>) = filter(data, ::isEven)
fun filterOdd(data: List<Int>) = filter(data, ::isOdd)

fun main(args: Array<String>) {
    val data = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 짝수 filtering
    var result = filterEven(data)
    println(result)

    // 홀수 filtering
    result = filterOdd(data)
    println(result)

    // 익명 함수
    result = filter(data, fun(e: Int): Boolean {
        return e >= 5
    })

    // 익명 함수를 단일 표현식으로 표현하는 방법
    result = filter(data, fun(e: Int) = e >= 5)

    // 함수형 프로그래밍 언어: 코드 조각을 참조하는 기술
    //   : Lambda(람다)
    //  C++11/14
    //  C#4
    //  Java8

    // 함수 대신 람다를 사용할 수 있습니다.
    // result = filter(data, fun(e: Int) = e >= 5)
    result = filter(data, { e: Int ->
        e >= 5
    })

    // 인자의 타입이 추론 됩니다.
    result = filter(data, { e ->
        e >= 5
    })

    // 함수의 마지막 인자가 함수라면, 다음과 같이 표현 가능합니다.
    //  : 마지막으로 전달되는 람다의 블록을 함수의 바깥에 쓸 수 있습니다.
    // -> Trailing Lambda
    result = filter(data) { e ->
        e >= 5
    }

    // 람다의 인자가 1개 라면, it 로 참조할 수 있습니다.
    result = filter(data) { it >= 5 }




    println(result)

}