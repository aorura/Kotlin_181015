package ex14

// import 할 때 이름을 변경하는 기능을 제공합니다. - aliasing
import ex9.User as User9
import ex11.User as User11
import ex13.lastChar as lc

// 동일한 이름을 import 할 때 충돌을 해결할 수 있습니다: as
/*
fun main(args: Array<String>) {

    // println("Kotlin".lastChar())
    println("Kotlin".lc())
}
*/

// 확장 함수 특징


open class Car {
    open fun go() {
        println("Car go")
    }

    fun showOff() = println("I'm Real Car")


}

class Truck : Car() {
    override fun go() {
        println("Truck go")
    }


}

fun Car.showOff(n: Int) = println("I'm Car")
fun Truck.showOff() = println("I'm Truck")

// Binding(어떤 메소드를 호출할 지 결정하는 것)
//  - Static Binding
//    컴파일러가 결정하는 것
//    레퍼런스의 타입을 보고 결정하는 것

//  - Dynamic Binding(virtual call, dynamic dispatch)
//    런타임에 변수에 담겨진 객체의 타입을 보고 결정하는 것

// * 중요: 확장 함수는 정적 바인딩을 합니다.
//        동일한 시그니쳐의 메소드가 클래스 안에서 존재할 경우,
//        확장 함수는 절대 호출되지 않습니다.

fun main(args: Array<String>) {
    // Truck is a Car
    val car: Car = Truck()

    // car.go()  // Truck.go()
    car.showOff(42)
}














