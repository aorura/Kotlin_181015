package ex19

// class List<E> { /*  */ }

// Generic
//   List<String>, List<Int>
//  1) 코드 생성
//  -> class List<String> { /* E = String */ }
//  -> class List<Int>    { /* E = Int */ }
//  문제점: 제네릭 인자의 타입이 변경될 때마다, 코드 메모리 사용량이 올라간다.
//        실제로 그 타입이 존재한다.

//  2) 타입 제거
//   class List { Object[] data }
//   List list = new List();
//   list.add(new Integer(42));
//   list.add("Hello");

//   String s = (String)list.get(0);
//    - 캐스팅
//    - 어떤 타입인지 정확하게 체크해야 한다.

//   컴파일러가 타입을 체크하고, 캐스팅을 없애주는 목적으로만 사용된다.
// val list1: List<String> = listOf("A", "B")
// val list2: List<Double> = listOf(1.0, 2.0, 3.0)

//  => JVM 내부 타입
//     list1: List
//     list2: List

/*
// Generic
inline fun <reified T> isA(value: Any) = value is T

// 위의 함수를 자바에서는 절대 구현할 수 없습니다.
// 이유?
//   자바의 제네릭은 타입 소거(Type erasure)를 사용해 구현됩니다.

fun main(args: Array<String>) {
    val list1: List<String> = listOf("A", "B")
    val list2: List<Double> = listOf(1.0, 2.0, 3.0)

    println(isA<String>(list1[0]))  // true  // value is String
    println(isA<Double>(list1[0]))  // true  // valus is Double
}
*/

// 활용 사례 - Android
open class Context {
    fun startActivity(context: Context, activityClass: Class<out Activity>) {
        val new = activityClass.newInstance()
        new.create()
    }
}

open class Activity : Context() {
    open fun onCreate() {
        println("onCreate Activity")
    }

    fun create() {
        // ...
        onCreate()


    }
}

class SignInActivity: Activity()

class MainAcitivity: Activity() {
    override fun onCreate() {
        super.onCreate()

        println("onCreate MainActivity")

        // Button이 눌렸을 때
        // startActivity(this, SignInActivity::class.java)
        startActivity<SignInActivity>()
    }
}

// Kotlin
inline fun<reified T: Activity> Context.startActivity() {
    startActivity(this, T::class.java)
}

fun main(args: Array<String>) {
    MainAcitivity().create()
}











