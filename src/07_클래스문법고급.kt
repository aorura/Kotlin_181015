package ex7

// 프로퍼티 2가지
//  1) Field가 존재하는 프로퍼티
//  2) 메소드를 편리하게 사용하는 프로퍼티

class User(name: String) {
    val name: String
        get() {
            return "User"
        }

    init {
        // this.name = name
    }
}

// extends: 구현 상속
// implements: 인터페이스 상속

// Kotlin's Interface
//  1. 프로퍼티도 인터페이스로 명세할 수 있다.
//  2. 인터페이스가 기본 구현도 제공할 수 있습니다.
//   : 다이아몬드 상속과 비슷한 문제가 발생할 수 있습니다.
interface Clickable {
    fun click()
    fun showOff() {
        println("I'm Clickable")
    }
}

interface Focusable {
    // 'Backing Field'가 존재하지 않는 프로퍼티에 대한 명세
    val name: String
    // : getter만 정의하면 된다.

    var age: Int
    // : getter + setter 모두 정의해야 한다.

    fun showOff() {
        println("I'm Focusable")
    }
}


class Button : Clickable, Focusable {
    override var age: Int
        get() {
            TODO("not implemented")
        }
        set(value) {}

    override val name: String
        get() {
            return "Button"
        }

    override fun click() {
        println("clicked")
    }

    override fun showOff() {
        println("I'm Button")
        super<Focusable>.showOff()
        super<Clickable>.showOff()
    }
}

/*
fun main(args: Array<String>) {
    val button = Button()
    println(button.age)
}
*/

// Interface의 장점?
//  : 교체 가능한 유연한 설계 때문에

// OCP: 개방 폐쇄의 원칙
//  : 수정에는 닫혀 있고, 확장에는 열려 있어야 한다.
// => 새로운 기능이 추가되어도 기존 코드는 수정되면 안된다.

// DIP: 의존 관계 역전 원칙
//  : 클라이언트는 구체적인 타입에 의존하는 것이 아니라
//    인터페이스나 추상 클래스에 의존해야 한다.

// 인터페이스의 문제점
//  : 변화에 대응하기 어렵다.

// 현대적인 객체 지향 언어에서는 인터페이스에 기본 구현을
// 제공할 수 있습니다.

interface Playable {
    fun play()
    fun stop()

    // default(defender) method
    fun playOneMinute() {
        play()
        // ..
        stop()
    }
}

class Mp3: Playable {
    override fun play() {
        println("play music")
    }

    override fun stop() {
        println("stop music")
    }
}

class Smartphone: Playable {
    override fun play() {
        println("play music")
    }

    override fun stop() {
        println("stop music")
    }
}

class Person {
    fun playMusic(mp3: Playable) {
        mp3.play()
        mp3.stop()
    }
}

fun main(args: Array<String>) {
    val person = Person()
    val mp3 = Mp3()
    val smartphone = Smartphone()

    person.playMusic(smartphone)
}










































