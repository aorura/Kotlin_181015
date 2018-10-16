package ex3

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable

interface State : Serializable
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Button : View {
    override fun getCurrentState(): State {
        return ButtonState()
    }

    override fun restoreState(state: State) {
        // ...
    }

    // 중첩 클래스가 됩니다.
    class ButtonState: State

    // 내부 클래스를 만드는 키워드: inner
    // 내부 클래스(Inner class): 내부 클래스 객체는 외부 클래스 객체의 참조를 암묵적으로 포함한다.
    //   => 메모리 누수 및 직렬화에 문제가 발생할 수 있다.
    //   Adapter or Iterator

    // 중첩 클래스(Nested class): 외부 클래스 객체에 대한 참조가 존재하지 않습니다.
}

// 코틀린은 모든 예외를 반드시 처리할 필요가 없습니다.
fun main(args: Array<String>) {
    val button = Button()

    val fos = FileOutputStream("state.dat")
    val oos = ObjectOutputStream(fos)

    oos.writeObject(button.getCurrentState())
}











