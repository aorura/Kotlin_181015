// 02_기본문법2.kt
//  클래스 관련 문법을 정리합니다.

/*
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
*/

// version 1.
// 1. default가 public 입니다.
// public class User

// 2. property
//   필드와 접근자 메소드를 자동으로 생성해주는 문법입니다.
package ex2

import java.util.*

/*
class User {
    // var: getter + setter
    // val: getter
    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
*/

// version 2.
// class User constructor(name: String, age: Int) {
/*
class User(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }
}
*/

// equals를 재정의 하지 않을 경우, ==는 참조 동등성과 동일하게 동작한다.
/*
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;

        // Reflection
        if (other.getClass() != User.class)
            return false;

        User user = (User)obj;
        return user.age == age &&
               Objects.eqauls(user.name, name);
    }

 */

/*
class User(var name: String, var age: Int) {
    override fun hashCode(): Int {
        return Objects.hash(age, name)
    }

    override fun equals(other: Any?): Boolean {
        if (other === null)
            return false

        if (other === this)
            return true

        if (other.javaClass !== javaClass)
            return false

        other as User
        return other.age == age &&
                other.name == name
    }
}
*/

// DAO, DTO => data class로 설계하라
data class User(var name: String,
                var age: Int,
                val address: String = "Suwon")

/*
fun main(args: Array<String>) {
    // 객체를 만드는 방법
    //  : new 키워드는 더 이상 사용하지 않습니다.
    val user1 = User("Tom", 42)
    val user2 = User("Tom", 42)

    println(user1)
    println(user2)

    // 동등성 판단
    //  1) 객체 동등성(equals) -> ==
    //  : 동일한 내용을 가지고 있는가?
    //  2) 참조 동등성(==)     -> ===
    //  : 동일한 참조(즉 같은 객체)인가?

    // Java's common library
    //  => Guava

    // if (user1 != null && user1.eqauls(user2))
    // if (Objects.eqauls(user1, user2))

    // Kotlin의 객체 동등성 비교는 널 안정성을 보장합니다.
    if (user1 == user2) {
        println("Same object")
    } else {
        println("Different object")
    }
}
*/

// 기본 연산자
fun main(args: Array<String>) {
    // 2진수 리터럴 문법
    // 1011
    val n  = 0b1101
    println(n.toString(2))

    // Bit shift   <<(shl), >>(shr), >>>(ushr)
    println(n shl 1)
    println(n shr 2)
    println(n ushr 3)

    // Bit logical &(and), ~(not), ^(xor), |(or)
    println(n and 0b1100)
    println(n or 0b1100)
    println(n xor 0b1100)
    println(n.inv())
}
















