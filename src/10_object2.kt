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







