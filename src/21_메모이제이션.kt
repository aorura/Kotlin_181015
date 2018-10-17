package ex21

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.*

// 동적 계획법
// Memoization: map.getOrPut

val map = mutableMapOf<Int, Long>()
fun fib(k: Int): Long = map.getOrPut(k) {
    when (k) {
        0 -> 1
        1 -> 1
        else -> fib(k - 1) + fib(k - 2)
    }
}

/*
fun fib(k: Int): Long = when (k) {
    0 -> 1
    1 -> 1
    else -> fib(k - 1) + fib(k - 2)
}
*/
// pure function: 인자가 동일하면 결과도 동일하다.
//  => 한번 계산된 데이터는 캐시하겠다.

//  fib(50)
//   = fib(49)        +     fib(48)
//   fib(48) + fib(47)   fib(47) + fib(46)

// hashCode() / eqauls()가 정의되어 있어야 한다.
data class User(val name: String, val age: Int, val address: String, val level: Int)

// HashMap을 Cache로 사용한다면, 어느 순간 너무 많은 메모리를
// 차지하고 있다.
//  => G.C가 발생할 때마다, 내부의 메모리를 해지하는 WeakHashMap

fun <A, R> ((A) -> R).memoized(): (A) -> R {
    val map = WeakHashMap<A, R>()
    // val map = mutableMapOf<A, R>()
    return { k ->
        map.getOrPut(k) {
            this(k)
        }
    }
}


fun User.toJson(): String {
    println("toJson()")
    val gson = GsonBuilder().setPrettyPrinting().create()
    return gson.toJson(this)
}

fun main(args: Array<String>) {
    val users = listOf(
            User("Tom", 42, "Suwon", 40),
            User("Tom", 43, "Suwon", 40),
            User("Tom", 44, "Suwon", 40),
            User("Tom", 45, "Suwon", 40),
            User("Tom", 42, "Suwon", 40));

    // val toJson = ::toJson.memoized()
    val toJson = User::toJson.memoized()

    for (e in users) {
        println(toJson(e))
    }

    // println(user.toJson())

    // user.toJson()
    //  { "name": "Tom", "age": 42 }


    // println(fib(50))
}











