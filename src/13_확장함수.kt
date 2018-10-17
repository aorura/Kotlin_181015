package ex13

import java.lang.StringBuilder

// 확장 함수(Extension Function)
//  => 기존 자바 API를 재작성하지 않고도 코틀린이 제공하는 기능을
//     사용할 수 있도록 한다.


// 기존의 클래스를 확장해서 사용하고 싶다.
// 상속: 수직 확장
//  1) 깨지기 쉬운 기반 클래스 문제
//  2) 상속 금지된 클래스는 확장하는 것도 불가능하다.

//  수평 확장
// ObjC  - Category
// Swift - Extension
// C#    - Extension Method
// Javascript - Prototype
//  => Kotlin: Extension Function

class User(val name: String) {
    // Thiscall: 모든 메소드는 this가 자동적으로 전달된다.
    fun printName() {
        // fun printName(this: User)
        println(name)
        //      this.name
    }
}

// String의 마지막 글자를 얻어오는 함수
// fun lastChar(text: String): Char = text[text.length - 1]

// String.: 수신 객체 타입
// this: 수신 객체
fun String.lastChar(): Char = this[this.length - 1]
// private / protected는 사용할 수 없습니다.

// s = "hello", "world", "show", "me"

// joinToString(s, ",", "[", "]")
// -> "[ hello, world, show, me ]"

fun <T> joinToString(collection: Collection<T>,
                     seperator: String,
                     prefix: String,
                     postfix: String): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0)
            result.append(seperator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}


fun main(args: Array<String>) {
    val v = listOf("Hello", "Show", "me", "Money")
    val result = joinToString(v, ", ", "[", "]")
    // v.joinToString(v)
    println(result)

    val s = "Hello"
    println(s.lastChar())

//    val s = "Hello"
//    println(lastChar(s))
}

// Intent intent = new Intent(this, LoginActivity.class)
// startActivity(intent)

// Anko
// startActivity<LoginActivity>()























