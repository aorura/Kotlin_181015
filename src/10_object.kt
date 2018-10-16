package ex10

// object keyword
// 1. object declaration - Singleton
//   : Scala(JVM)
/*
object Cursor {
    var name: String
    var age: Int

    // 초기화: 생성자가 아닌 초기화 블록을 사용해야 합니다.
    init {
        println("Cursor object created")
        name = "Tom"
        age = 42
    }

    fun move() {
        println("cursor move")
    }
}

fun main(args: Array<String>) {
    println("main")
    Cursor.move()
}
*/


// 2. companion object(동반 객체)
//  = static field + static method 대체 하는 문법

// Kotlin 언어는 static을 지원하지 않습니다.
//  1) Companion object
//  2) 패키지 최상위 메소드 + 프로퍼티

// Constant(상수)
// C#(const, readonly)
// C++(const, constexpr)
//  1. 컴파일 상수: const, constexpr(const)
//    : 메모리 공간을 별도로 차지하지 않는다.
//  2. 런타임 상수: readonly, const
//    : 메모리 공간이 존재한다.

/*
class User {
    // 클래스 간에 하나만 존재하는 객체 - 동반 객체
    //  정적 필드와 메소드를 구현하면 됩니다.
    // companion object Shared {
    companion object {
        // static final String TAG = "User"
        // const val TAG = "User"
        val TAG: String = User::class.java.simpleName

        /*
        static fun className(): String {
            return "User"
        }
        */
        fun className(): String {
            return "User"
        }
    }

    fun foo() {
        // Log.i(TAG, "foo()");
    }
}

fun main(args: Array<String>) {
    println(User.className())
    println(User.TAG)
}
*/


// 3. anonymouse object(익명 객체 또는 무명 객체)


// 방법 1. Dialog가 OnClickListener를 구현한다.
//   한계?
//     반드시 어떤 객체로부터 이벤트가 전달되었는지를 확인할 수 있어야 한다.
/*
class Dialog: OnClickListener {
    fun open() {
        println("Dialog open")
    }
    fun close() {
        println("Dialog close")
    }

    override fun onClick(view: Button) {
        // view.getId()
        // case R.id.button_close: ...
        // case R.id.button_open: ...
        when (view.id) {
            10 -> close()
            20 -> open()
        }
    }
}

fun main(args: Array<String>) {
    val closeButton = Button(10)
    val openButton = Button(20)
    val dialog = Dialog()

    openButton.onClickListener = dialog
    closeButton.onClickListener = dialog

    closeButton.click()
}
*/

interface OnClickListener {
    fun onClick(view: Button)
}

class Button(val id: Int) {
    var onClickListener: OnClickListener? = null

    fun click() {
        onClickListener?.onClick(this)
        /*
        if (onClickListener != null)
            onClickListener.onClick()
        */
    }
}


// 방법 2. OnClickListener를 구현하지 않는다.
class Dialog {
    fun open() {
        println("Dialog open")
    }
    fun close() {
        println("Dialog close")
    }
}

fun main(args: Array<String>) {
    val dialog = Dialog()
    val openButton = Button(10)
    val closeButton = Button(20)

    // Closure: 외부에 존재하는 객체의 참조에 암묵적으로 접근하는 문법
    //   Java 7: final
    openButton.onClickListener = object: OnClickListener {
        override fun onClick(view: Button) {
            dialog.open()
        }
    }

    closeButton.onClickListener = object: OnClickListener {
        override fun onClick(view: Button) {
            dialog.close()
        }
    }

    // openButton.onClickListener = new OnClickListener() {
    //   @Override
    //   void onClick(Button button) {
    //       dialog.close();
    //   }
    // };


}














