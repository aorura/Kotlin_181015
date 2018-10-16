package ex10

// object keyword
// 1. object declaration - Singleton
//   : Scala(JVM)
/*
object Cursor {
    var name: String
    var age: Int

    // 초기화: 생성자가 아닌 초기화 블록을 사용해야 합니다.
    init {
        println("Cursor object created")
        name = "Tom"
        age = 42
    }

    fun move() {
        println("cursor move")
    }
}

fun main(args: Array<String>) {
    println("main")
    Cursor.move()
}
*/


// 2. companion object(동반 객체)
//  = static field + static method 대체 하는 문법

// Kotlin 언어는 static을 지원하지 않습니다.
//  1) Companion object
//  2) 패키지 최상위 메소드 + 프로퍼티

class User {
    // 클래스 간에 하나만 존재하는 객체 - 동반 객체
    //  정적 필드와 메소드를 구현하면 됩니다.
    // companion object Shared {
    companion object {
        // static final String TAG = "User"
        val TAG = "User"

        /*
        static fun className(): String {
            return "User"
        }
        */
        fun className(): String {
            return "User"
        }
    }

    fun foo() {
        // Log.i(TAG, "foo()");
    }
}

fun main(args: Array<String>) {
    println(User.className())
    println(User.TAG)
}


// 3. anonymouse object


















