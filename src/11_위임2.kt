package ex11

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// Delegation for Property
//   getter + setter 동작을 다른 객체가 대신하는 것
class SampleDelegate {
    operator fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("getValue")
        return "$thisRef - ${property.name}"
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("setValue")
        println("$thisRef - ${property.name} to $value")
    }
}

/*
class User {
    // KProperty<String>
    var name: String by SampleDelegate()
}

fun main(args: Array<String>) {
    val user = User()
    println(user.name)

    user.name = "Bob"
}
*/

// 코틀린이 제공하는 다양한 표준 델리게이트가 있습니다.
// 1. lazy(지연된)
//  : val 프로퍼티에 대한 초기값을 객체가 초기화하는 시점이 아니라
//    처음으로 접근되는 시점에 결정하고 싶다.

/*
fun resolveUserName(): String {
    // Network 으로부터 이름을 받아온다.
    println("reloveUserName")
    Thread.sleep(1000 * 2)
    return "Tom"
}

class User() {
    // val name: String = resolveUserName()
    // 1. lazy - val
    /*
    val name by lazy {
        resolveUserName()
        // * 블록의 마지막 표현식의 결과가 블록의 결과가 됩니다.
        // * 블록의 실행은 스레드 안정성이 보장됩니다.
    }
    */
    // 2. lateinit - var
    //   * setter / getter 재정의 할 수 없다.
    //   * Primitive Type은 사용할 수 없습니다.
    //     (Int, Double, Long, Float)
    lateinit var name: String
}

fun main(args: Array<String>) {
    println("main")
    val user = User()
    user.name = "Bob"
    println(user.name)
}
*/

// 2. KVO: Key-Value Observation
//   : iOS 에서 많이 사용하는 기술
//  => 프로퍼티의 값이 변경되는 것을 통보 받는 기술

/*
// View
class TextView {
    var text: String = ""
        set(value) {
            println("Update TextView's text to $value")
            field = value
        }
}

// Controller
class Activity {
    // val model = Model()

    val nameTextView = TextView()

    // var name: String = ""
    var name by Delegates.observable("") { _, old, new ->
        println("$old -> $new")
        nameTextView.text = new
    }

    fun onCreate() {
        name = "Hello"
        name = "Bob"

        // nameTextView.text = "Hello"
        // model.name = "Hello"
    }
}

fun main(args: Array<String>) {
    val activity = Activity()
    activity.onCreate()

    // activity.name = "Tom"
    // activity.name = "Bob"
}


// Model
class Model {
    var name: String = ""
}
*/

/*
// 3. KVC - Key value coding
// Map<String, Any> : JSON

// Json serializer: Gson

// REST API Client
//     OkHttp + Gson + Retrofit + RxJava

class User(map: Map<String, Any>) {
    val name: String by map
    val age: Int by map
    val address: String by map

    // 초기화 블록의 코드는 프로퍼티가 변경될 때마다 수정되어야 한다.
    /*
    init {
        name = map["name"] as String
        age = map["age"] as Int
    }
    */

    override fun toString(): String {
        return "User(name='$name', age=$age, address=$address)"
    }
}

fun main(args: Array<String>) {
    val userJson = mapOf("name" to "Tom", "age" to 42, "address" to "Suwon")
    val user = User(userJson)
    println(user)
}
*/

// 4. vetoable: 프로퍼티가 설정한 조건이 부합되지 않으면, 값이 변경되지 않음
class User {
    var name by Delegates.vetoable("")
    { _, old, new ->
        old != new && new.length >= 5
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "Tom123"

    println(user.name)
}


























