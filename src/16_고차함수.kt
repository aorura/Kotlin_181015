package ex16

// 고차 함수(Higher order function)
// : 함수의 객체를 인자로 받거나 함수를 반환하는 함수

// Why?
// 고차 함수의 방식을 자바에서 구현하는 방법
//  => 동작 파라미터화 설계


// Kotlin은 Collection의 인터페이스에 변경이 있습니다.
//          List<E>: Immutable Collection Interface
//   MutableList<E>: Mutable
//   ArrayList
//   LinkedList

//          Set<E>: Immutable
//   MutableSet<E>: Mutable
//   TreeSet
//   HashSet

//           Map<K, V>: Immutable
//    MutableMap<K, V>: Mutable
//   TreeMap
//   HashMap

// 선형적인 자료구조에서 filter의 알고리즘은 변하지 않는다.
// 사용자마다 filter 하고자 하는 정책은 변한다.
//  => 변하지 않는 알고리즘에서 변하는 정책은 분리되어야 한다.
//  => '공통성' 과 '가변성'은 분리되어야 한다.
fun filterEven(data: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (e in data) {
        if (e % 2 == 0)
            result.add(e)
    }

    return result
}

fun filterOdd(data: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (e in data) {
        if (e % 2 == 1)
            result.add(e)
    }

    return result
}


fun main(args: Array<String>) {
    val data = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 짝수 filtering
    var result = filterEven(data)
    println(result)

    // 홀수 filtering
    result = filterOdd(data)
    println(result)
}









