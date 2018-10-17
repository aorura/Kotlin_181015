package ex20

class Person(val name: String)

// Kotlin은 람다와 함수는 다릅니다.
//  람다: 코드 블록 - return: 자신을 감싸고 있는 함수가 반환(비지역 반환)
//  함수: 호출하는 코드 블록 - return

// 지역 반환: 람다 블록에서만 탈출할 수 있습니다.
/*
fun lookForAlice(people: List<Person>) {
    people.forEach hello@{ person ->
        if (person.name == "Alice") {
            println("Found")

            // 지역 반환
            // return@forEach
            return@hello
        }
    }

    println("Alice is not found")
}
*/

fun lookForAlice(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") {
            println("Found")

            return
        }
    })

    println("Alice is not found")
}


/*
fun lookForAlice(people: List<Person>) {

    // 아래의 루프 안에서 return을 사용하면, 함수형태로 변경하는 것이 힘들다.
    //  => 코틀린 이외의 모든 언어
    for (person in people) {
        if (person.name == "Alice") {
            println("Found")
            return
        }
    }

    println("Alice is not found")
}
*/


fun main(args: Array<String>) {
    val people = listOf(Person("Bob"),
            Person("Alice"))
    lookForAlice(people)
}