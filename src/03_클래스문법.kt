package ex3

class Destination(val address: String) {
    override fun toString(): String {
        return address
    }

    fun name(): String {
        return "Destination: $address"
    }
}

class Car(val name: String, val speed: Int) {

    fun go() {
        println("go")
    }

    fun go(speed: Int) {
        println("go speed: $speed")
    }

    fun go(speed: Int, color: Int) {
        println("go speed: $speed color: $color")
    }


    // Method를 만드는 방법
    //  Java: 문자열을 + 연산자를 통해 조합할 수 있습니다.
    //  Kotlin: 문자열을 쉽게 만들 수 있는 기능을 제공합니다.
    //     String interpolation
    //     String template
    fun go(destination: Destination) {
        // println("go to " + destination)
        println("go to ${destination.name()}")
    }
}

fun main(args: Array<String>) {
    val car = Car("BMW", 120)
    car.go(Destination("Seoul"))

    val b = 10
    val a = 100

    car.go()
    // car.go(speed)

    // 동일한 타입의 인자를 전달할 때,
    // 어떤 파라미터로 전달될지 지정하는 기능도 제공하고
    // 있습니다.
    // car.go(color = a, speed = b)
    car.go(speed = a, color = b)
}








