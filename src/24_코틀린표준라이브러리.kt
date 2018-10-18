package ex24

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

// 1. 조건 확인 함수
//  : assert

// error   -> errorStateException
// TODO    -> NotImplementedError
// check   -> IllegalStateException
// require -> IllegalArgumentException

// Anko
//   Fragment
//      getActivity() -> Activity
/*
fun foo(filename: String, message: String) {
    // TODO("아직 만들고 있습니다.")

    val file = File(filename)

    require(message.isBlank().not()) {
        "message should not blank"
    }
//    if (message.isBlank()) {
//        throw IllegalArgumentException("message should not blank")
//    }

    check(file.exists()) {
        "File not found"
    }
//    if (!file.exists()) {
//        throw IllegalStateException("File not found")
//    }


}

fun main(args: Array<String>) {
    error("error!!")
    // foo("file.txt", "hello")
}
*/

// 2. Stream API
//   => Java 8에 추가된, 컬렉션에 포함된 자료들을 편리하게 다룰 수 있는 기능을 제공합니다.
//      컬렉션에 포함된 데이터를 변환하거나, 새로운 데이터를 생성하거나, 등의 작업을
//      편리하게 할 수 있습니다.

//  C++: <algorithm>
//  Javascript: undescore.js, lodash.js
//  C#: 2010, LINQ(Language-Integrated Query)

//         val user = select user from users;
// Collection     Database                       Excel
//   List           MSSQL, MySQL, PostgreSQL

//  Java 8: Stream API
//  Kotlin: Java 6      - Sequence API
//          Java 8      - Stream API
/*
fun main(args: Array<String>) {
    val cities = listOf("Seoul", "Suwon", "Busan", "Daegu")

    // result = cities.map(String::toUpperCase)
    //  : 명령형 프로그래밍
    // val result = mutableListOf<String>()
    // for (e in cities) {
    //     result.add(e.toUpperCase())
    // }

    // : 선언적 프로그래밍
    //  -> 직접 구현하는 것이 아니라, 제공되는 연산을 조합해서 문제를 해결하는 방법.
    //  1) 가독성이 좋다.
    //  2) 병렬화가 쉽다.


    // 1. 변환(transform), map
    var result = cities.map {
        it.toUpperCase()
    }

    // 2. filter
    // (String) -> String
    //  : Method Reference

    // .asSequence(): Sequnce로 변환한다.
    cities.asSequence()
            .filter {
                it.startsWith("S")
            }
            .map(String::toUpperCase)
            .forEach(::println)

    // 3. Nullable
    /*
    val values = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    values.map {
        when {
            it % 2 == 0 -> it
            else -> null
        }
    }.filter {
        it != null
    }.forEach(::println)

    */

    // 3. mapNotNull - map의 변환 과정에서 null이 발생할 경우, 자동으로 필터링 해준다.
    val values = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    values.mapNotNull {
        when {
            it % 2 == 0 -> it
            else -> null
        }
    }.forEach(::println)

    // Stream / Sequnce operation
    // map
    //   List<Int> -> List<List<Int>>

    // flatMap
    //   List<Int> -> List<Int>

    // Rx
    // map
    //   Obseravable<Int> -> Observable<Observable<Int>>

    // 4. flatMap
    //   Obseravable<Int> -> Observable<Int>
    val names = listOf("Tom", "Alice", "Gildong")
    val result2 = names.flatMap {
        it.map { char ->
            char.toString()
        }
    }

    println(result2)

    // 5. 분류 작업 - groupBy
    val cities2 = listOf("seoul", "suwon", "daegu", "busan", "daejeon")

    // 문자열의 길이에 따라서 분류하고 싶다.
    // List<String> -> Map<Int, List<String>>

    // 알파벳 첫글자로 분류하고 싶다.
    // List<String> -> Map<Char, List<String>>

    val result3 = cities2.groupBy {
        // it.length
        it[0]
    }

    val cities4 = result3.keys.sorted()
    cities4.forEach {
        println("group: $it, cities: ${result3[it]}")
    }

//    result3.forEach { g, cities ->
//        println("group: $g, cities: $cities")
//    }


    println(result3)

    // Designer - Zeplin
    //   mac: Sketch
    //   windows: Adobe XD

    // REST API
    //   : Paw, 'Postman'
    // Vysor(무료 버전)
}
*/



// first/last: 조건에 맞는 첫번째(마지막) 원소를 가져옵니다.
//   -> 찾지 못한 경우는 예외가 발생합니다.
//   -> firstOrNull을 이용하면 null을 반환하도록 할 수 있습니다.


// distinct: 중복된 항목을 걸러낸 결과를 반환합니다.
//  (unique)

// Set은 중복을 허용하지 않습니다.
//   val data = setOf(list)
/*
fun main(args: Array<String>) {
    // val list = 1..10
    val list = emptyList<Int>()// listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(list.map { it % 2 }.distinct())

    // [] 연산은 Range에 대해서는 사용할 수 없습니다.
    // println(list[0])
    // list가 비어져 있다면, out of index 가 발생합니다.
    // println(list.firstOrNull())

    list.firstOrNull {
        it % 2 == 0
    }?.let {
       println(it)
    }

//    val e = list.firstOrNull {
//        it == 5
//    }

}
*/

// take / drop
/*
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

//    val result = list.takeWhile {
//        it < 5
//    }
    // val result = list.take(5)
    // val result = list.drop(3)
    val result = list.dropWhile {
        it < 5
    }
    println(result)
}
*/


// zip
//  : 두 컬렉션 내의 자료들을 조합해서 새로운 자료를 만듭니다.
fun main(args: Array<String>) {
    val countries = listOf("Korea", "United States", "China")
    val codes = listOf("KR", "US", "CN")

    // Default Pair
    countries.zip(codes).forEach {
        println("${it.first} - ${it.second}")
    }

    countries.zip(codes) { country, code ->
        "$country($code)"
    }.forEach {
        println(it)
    }
}


















