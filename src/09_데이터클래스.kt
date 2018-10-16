package ex9

//class User(val name: String, val age: Int) {
//    override fun toString(): String {
//        return "User(name=$name, age=$age)"
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as User
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        return result
//    }
//
//    operator fun component1(): String {
//        return name
//    }
//
//    operator fun component2(): Int {
//        return age
//    }
//}

data class User(val name: String, val age: Int)

fun main(args: Array<String>) {
    val user = User("Tom", 42)

    // 1. 객체를 문자열로 표현하는 방법: Any.toString()
    println(user)
    val other = User("Tom", 42)

    // 2. 객체의 동등성: Any.equals() / Any.hashCode()
    println(user == other)

    //---------------------------------------------

    // 3. 객체를 복사하는 함수: copy()
    //  : 특정 필드만 변경하는 기능도 지원하고 있습니다.
    // val newUser = user.copy(name = "Bob")
    // val ageUser = user.copy(age = 30)

    // 4. 비구조화 선언
    // val users = listOf(user, other, newUser, ageUser)

    // 5. 코틀린의 주요 기능
    //   : 연산자 오버로딩이 추가되었습니다.
    //    -> 연산자를 통해 특정한 메소드를 호출하는 기능을 의미합니다.

    val users = listOf(user, other)
    // users[0]

    // (component1, component2)

    for ((name, age) in users) {
        println("$name - $age")
    }

//    for ((name, _) in users) {
//        println(name)
//    }
    /*
    for (e in users) {
        println(e)
        // e.name, e.age
    }
    */
}















