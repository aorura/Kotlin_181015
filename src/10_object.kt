package ex10

// object keyword
// 1. object declaration - Singleton
//   : Scala(JVM)
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




// 2. companion object
// 3. anonymouse object


