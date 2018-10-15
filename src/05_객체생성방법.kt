// 생성자 오버로딩을 통해 객체를 생성할 수 있는 다양한 방법을 제공한다.
// => 생성자의 인자가 많을 경우, 빌더 패턴을 고려하라.
/*
class User {
    val name: String
    val address: String
    val age: Int
    val level: Int

    constructor(name: String, address: String, age: Int, level: Int) {
        this.name = name
        this.address = address
        this.age = age
        this.level = level
    }

    constructor(name: String, address: String, age: Int)
            : this(name, address, age, 0)

    constructor(name: String, address: String)
            : this(name, address, 0, 0)

    constructor(name: String)
            : this(name, "", 0, 0)
}
*/
package ex5

class User @JvmOverloads constructor(val name: String,
           val address: String = "",
           val age: Int = 0,
           val level: Int = 0)

fun main(args: Array<String>) {
    val a = "Tom"
    val b = "Suwon"
    val c = 42
    val d = 10

    val user1 = User(name = b, address = a, age = d, level = c)
    val user2 = User(b, a, c)
    val user3 = User(b, a)
    val user4 = User(b)
}