package ex11

interface UIElement {
    fun getHeight(): Int
    fun getWidth(): Int

    fun getSize()
}

open class Rectangle(val x1: Int,
                     val x2: Int,
                     val y1: Int,
                     val y2: Int) : UIElement {
    override fun getHeight(): Int {
        return y2 - y1
    }

    override fun getWidth(): Int {
        return x2 - x1
    }

    override fun getSize() {
        TODO("not implemented")
    }
}

// '상속'을 통해서 Rectangle의 구현을 물려 받는 방법
// '포함'을 통해서 Rectangle 객체에게 위임하는 방법

// Panel is a Rectangle
class Panel1(x1: Int, x2: Int, y1: Int, y2: Int)
    : Rectangle(x1, x2, y1, y2)

/*
class Panel(val rectangle: Rectangle) : UIElement {
    override fun getHeight(): Int {
        return rectangle.getHeight()
    }

    override fun getWidth(): Int {
        return rectangle.getWidth()
    }
}
*/

// Delegation Pattern
//   : by
// UIElement의 인터페이스에서 노출한 메소드에 대한 호출을 Rectangle객체로 위임합니다.
// => 반드시 프로퍼티로 만들 필요가 없습니다.
// => '포함'을 '상속'보다 편리하게 사용할 수 있도록 해줍니다.
class Panel(rectangle: Rectangle) : UIElement by rectangle

fun main(args: Array<String>) {
    val panel = Panel(Rectangle(10, 100, 30, 100))
    println(panel.getHeight())
    println(panel.getWidth())
}









