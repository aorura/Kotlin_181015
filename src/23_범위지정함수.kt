package ex23

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.StringBuilder
import java.net.ServerSocket
import java.nio.ByteBuffer

// 수신 객체 지정 람다 - 범위 지정 함수
class User(var email: String?)

fun sendEmail(email: String) = println("Send email to $email")

// 1. let
/*
fun main(args: Array<String>) {
    val user = User("chansik.yun@gmail.com")

    // sendEmail(user.email)
    // 특정한 값이 null이 아닐 경우, 다른 함수의 인자로 전달하고 싶거나
    // 특정 동작을 수행해야 한다.

    // user.email을 null이 없는 형태로 받아 올 수 있다.
    //  => 안전한 널 참조 연산과 같이 사용해야 한다.
    user.email?.let {
        sendEmail(it)
    }

    /*
    val email = user.email
    if (email != null) {
        sendEmail(email)
    }
    */
}
*/

// 2. with
/*
class TextView(var text: String? = null, var name: String? = null)
class Adapter {
    val holder: ViewHolder = ViewHolder()
}

class ViewHolder {
    val nameTextView: TextView = TextView()
    val ageTextView: TextView = TextView()
    val addressTextView: TextView = TextView()

    var name: String = "Hello"

    fun foo() {
        with (nameTextView) {
            text = "Tom"

            // ViewHolder.this.name
            println(this@ViewHolder.name)
        }
    }
}

fun main(args: Array<String>) {
    val adapter = Adapter()
    adapter.holder.foo()

    // with를 사용하지 않으면
    adapter.holder.nameTextView.text = "Tom"
    adapter.holder.ageTextView.text = "42"
    adapter.holder.addressTextView.text = "Suwon"

    // with가 있다면
    with (adapter.holder) {
        nameTextView.text = "Tom"
        ageTextView.text = "42"
        addressTextView.text = "Suwon"
    }
}
*/

/*
// 3. apply
//  : 함수의 결과가 this가 됩니다.
//  -> Builder와 같은 객체 초기화 과정이 복잡한 경우를 캡슐화하는 목적으로
//     많이 사용합니다.
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z')
        result.append(letter)
    result.append("\n")
    return result.toString()
}

fun alphabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z')
        append(letter)
    append("\n")
}.toString()

fun alphabet3() = buildString {
    for (letter in 'A'..'Z')
        append(letter)
    append("\n")
}
*/

// Effective Java: 비메모리 자원에는 반드시 명시적인 종료 메소드를 호출해야 한다.

// 4. use - Try with Resource(Java 7)
/*
fun main(args: Array<String>) {
    val serverSocket = ServerSocket(5000)
    val socket = serverSocket.accept()

    var inputStream: InputStream? = null
    var outputStream: OutputStream? = null

    try {
        inputStream = socket.getInputStream()
        outputStream = socket.getOutputStream()

        val buf = ByteArray(1024)
        while (true) {
            val len = inputStream.read(buf)
            if (len == -1)
                break
            outputStream.write(buf, 0, len)
        }


    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            inputStream?.close()
        } catch (e: IOException) {}

        try {
            outputStream?.close()
        } catch (e: IOException) {}
    }
}
*/

// 비메모리 자원에 대한 해지를 finalize에서 처리하면 안돼는 이유?
//  => finalize 문제점
//   1) 호출이 보장되지 않는다.
//   2) 호출 시점이 보장되지 않는다.
//   3) 자식이 오버라이딩 해서 부모의 finalize를 명시적으로 호출하지 않을 수 있다.

// File, Thread, Process, Mutex
//  : 비메모리 자원을 사용한다면, 반드시 명시적인 종료 메소드를 제공해야 한다.
//  -> AutoClosable
//   Java: Try with resource
// Kotlin: use
class MyResource : AutoCloseable {
    override fun close() {
        println("My Resource destroyed")
    }

    fun handle() = "Resource handle"
}

fun main(args: Array<String>) {
    val resource = MyResource()
    resource.use {
        it.handle()
    }

    // resource.close()
}







































