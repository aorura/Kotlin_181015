package ex22

// Nullable
//  : Null Pointer Exception
//   => 많은 에러, 시스템 크래시 원인

fun getName(): String? = null

class User(var name: String?)

fun foo(name: String) {}
fun goo(len: Int) {}

/*
fun main(args: Array<String>) {
    // 1. 일반 타입에는 null을 사용할 수 없습니다.
    // var name: String? = null  - Java
    // var name: String = "Hello"
    // var name = getName()
    val user = User(getName())

    // 2. Nullable 타입에 대해서는 반드시 null 체크가 필요합니다.
    /*
    if (user.name != null) {      // String?
        // Smart cast
        println(user.name.length) // String
    }
    */

    /*
        if val name = user.name {
            println(name.length)
        }
    */
    /*
    // 안전하게 처리 하는 방법
    val name = user.name
    if (name != null) {
        println(name.length)
    }

    val len = user.name?.length
    if (len != null) {
        println(len)
    }
    */

    // 3. 강제적으로 접근하는 방법
    // 절대 하지 말자. - 예외 발생의 위험이 있습니다.
    val name = user.name
    foo(name!!)

    val len = user.name?.length
    goo(len!!)
}
*/


class Person(name: String, val address: Address?)
class Address(name: String, postcode: String, val city: City?)
class City(name: String, val country: Country?)
class Country(val name: String)

// 가독성에 문제가 있습니다.
fun getCountryName(person: Person?): String? {
    var countryName: String? = null
    if (person != null) {
        val address = person.address
        if (address != null) {
            val city = address.city
            if (city != null) {
                val country = city.country
                if (country != null) {
                    countryName = country.name
                }
            }
        }
    }

    return countryName
}


fun getCountryName2(person: Person?): String? {
    if (person == null)
        return null;

    val address = person.address
    if (address == null)
        return null

    val city = address.city
    if (city == null)
        return null

    val country = city.country
    if (country == null)
        return null;

    return country.name
}

// 안전한 널 참조 연산 활용 예제(Safe null access operator)

// ?:
// -> Elvis operator
//  :  null일 경우 기본값을 지정하는 목적으로 사용한다.
fun getCountryName3(person: Person?): String {
    return person?.address?.city?.country?.name ?: "Unknown"
}





































