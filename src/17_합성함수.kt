package ex19

// Functional Javascript
//  underscore
//  lodash

// Function Composition
// f(x) -> y
// g(y) -> z
// compose(f(x), g(y)) -> g(f(x)) -> z

// Pure function
// : 함수의 인자가 동일하면 결과도 동일해야 한다.
/*
fun <A, B, C> compose(f: (A) -> B, g: (B) -> C): (A) -> C = { x ->
    val y = f(x)
    val z = g(y)
    z
}
*/



// 문자열의 길이를 구하는 함수: String.length: (String) -> Int
// 해시값을 구하는 함수: Any.hashCode:                  (Any) -> Int

/*
fun <A, B, C> compose(f: (A) -> B, g: (B) -> C): (A) -> C = {
    g(f(it))
}
*/

infix fun <A, B, C> ((A) -> B).compose(g: (B) -> C): (A) -> C = {
    g(this(it))
}

fun main(args: Array<String>) {
    val s = "Hello"
    val f = String::length
    val g = Any::hashCode
    // val f = s::length

    // val fog = compose(f, g)
    // val fog = f.compose(g)
    val fog = f compose g
    val inputs = listOf("Tomxxxx", "Bobxxxx", "Samxxxx")

    for (e in inputs) {
        println(fog(e))
    }


    // bound reference


}










