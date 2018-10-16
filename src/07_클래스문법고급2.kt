package ex7

// 코틀린 기본 클래스는 상속 금지가 되어 있습니다.

// public final class Car

// open: 상속 허용 / 오버라이딩 허용
// abstract: open이 기본입니다.

// Effective Java
//  : 기반 클래스를 변경하는 경우 하위 클래스의 동작이 예기치 않게 변경될 수 있다.
//    => 상속을 위한 설계와 문서를 갖추거나 그럴 수 없다면 상속을 금지하라.
open class Car {
    open val name: String
        get() {
            return "Car"
        }
    // final method가 기본입니다.
    //  : 자식이 부모의 메소드를 함부로 오버라이드 할 수 없습니다.
    open fun go() {
        println("Car go")
    }
}

// class Truck extends Car
class Truck: Car() {
    override val name: String
        get() {
            return "Truck"
        }

    override fun go() {

    }
}








