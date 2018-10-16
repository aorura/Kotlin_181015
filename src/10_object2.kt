package ex10

import java.io.File

// 1. object 선언
// 2. companion object
// 3. anonymous object

// Interface - Comparator
//  정책 클래스(Policy Class)
/*
class CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}
*/

/*
// object 선언을 통해 만든 객체는 인터페이스도 구현할 수 있고, 상속도 받을 수 있습니다.
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

// 중첩 클래스도 object 선언을 통해 하나만 생성할 수 있습니다.
class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(args: Array<String>) {
    val people = listOf(Person("Tom"), Person("Bob"))
    println(people.sortedWith(Person.NameComparator))

    val files = listOf(
            File("/C"),
            File("/A"),
            File("/B"))

    // println(files.sortedWith(CaseInsensitiveFileComparator()))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}
*/

// Companion Object - Static factory method
//  = 생성자 보다는 정적 팩토리 메소드를 제공하는 것이 좋다.
//  1. 생성자 오버로딩은 한계가 있다.
//    : 동일 타입을 받을 경우 제대로 오버로딩 할 수 없다.
//    User user = new User(email);
//    User user = new User(facebookId);

//  2. 생성자 호출의 이름은 변경될 수 없다.
//  3. 객체 생성의 정책을 변경할 수 없다.

// Kotlin 에서 생성자를 private을 만드는 방법
/*
class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String): User {
            return User(email.substringBefore("@"))
        }

        fun newFacebookUser(facebookId: String): User {
            return User("facebook@$facebookId")
        }
    }
}

fun main(args: Array<String>) {
    val e = "chansik.yun@gmail.com"
    val f = "10001123123"

    // val user1 = User(e)
    val user1 = User.newSubscribingUser(e)
    // val user2 = User(f)
    val user2 = User.newFacebookUser(f)
}
*/

// Companion Object는 인터페이스 구현도 가능하다.
//  => 정적 팩토리 메소드를 명세화 하는 것이 가능하다.

// 자바 vs 코틀린
// : 자바의 정적 메소드는 인터페이스 기반으로 구현하는 것이 불가능하다.
//   코틀린은 동반 객체라는 개념을 통해서 인터페이스 기반으로 정적 메소드를 만드는 것이
//   가능하다.
interface MapFactory<T> {
    fun fromMap(map: Map<String, Any>): T
}

fun <T> loadFromMap(factory: MapFactory<T>): T {
    val map = mapOf("name" to "Tom")
    return factory.fromMap(map);
}

// Map<String, Any> -> JSON
class Person(val name: String) {
    companion object: MapFactory<Person> {
        override fun fromMap(map: Map<String, Any>): Person {
            val name = map["name"] as String
            return Person(name)
        }
    }
}

// 1. Kotlin in Action
// 2. 코틀린 프로그래밍
// 3. 빅 너드 렌치
fun main(args: Array<String>) {
    val person = loadFromMap(Person)
}

// 1. 야곰's 스위프트 프로그래밍
// 2. 빅 너드 렌치






















