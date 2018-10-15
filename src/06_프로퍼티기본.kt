package ex6

// 1. Property
//   Field + Accessor method(Getter + Setter)
//   val: getter
//   var: getter + setter
// class User(val name: String, val age: Int)

/*
//   프로퍼티의 getter 또는 setter를 재정의하고 싶다.
class User(name: String, age: Int) {
    var name: String = ""
        set(value) {
            println("name setter")
            field = "$value,"
        }
        get() {
            // field 키워드를 통해 실제 메모리에 접근할 수 있습니다.
            println("name getter")
            return "name: $field"
        }

    var age: Int = 0 // setter
        set(value: Int) {
            println("age setter")
            field = value + 1
        }


    init {
        // setter가 호출됩니다.
        this.name = name
        this.age = age
    }
}

fun main(args: Array<String>) {
    val user = User("Tom", 42)
    println(user.name)
    // getter를 호출합니다.

    user.age = 100
    // setter를 호출합니다.
}
*/

// 2. 'Backing Field'가 존재하지 않는 프로퍼티도 만들 수 있습니다.
class User(var firstName: String, var lastName: String) {
    // method를 만든다.
    fun xgetFullName(): String {
        return "$firstName, $lastName"
    }

    // property를 만든다.
    var fullName: String
        get() {
            return "$firstName, $lastName"
        }
        set(value: String) {
            val arr = value.split(" ", ", ", ",")
            firstName = arr[0]  // arr.get(0)
            lastName = arr[1]
        }
}

fun main(args: Array<String>) {
    val user = User("Gildong", "Hong")
    // println(user.getFullName())
    println(user.fullName)
    user.fullName = "Chansik, Yun"

    println(user.firstName)
    println(user.lastName)
}

// 주의사항
//  프로퍼티? 메소드?
// 1) 복잡한 코드는 메소드를 사용해야 한다.
// 2) 시간이 오래 거리는 작업은 메소드를 사용해야 한다.
// 3) 프로퍼티의 값을 얻는 getter의 동작에서 프로퍼티의 상태가 변경되면 안됩니다.
//    또는 다른 값의 부수효과가 발생하면 안됩니다.
// 4) 프로퍼티의 경우 절대 예외가 발생하면 안됩니다.
// 5) 타입을 다른 타입으로 변환하는 경우?
//   => 메소드로 약속되었습니다.
//    obj.toString()
//    obj.toLong()
//    obj.toJson()

// 6) 객체를 복제하는 경우도 메소드를 사용합니다.
















