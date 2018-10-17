package ex19

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

// lock()과 unlock()을 명시적으로 호출하는 것은 좋지 않다.
//  : 임계 영역에서 예외가 발생할 경우, 데드락의 위험성이 있다.
//   => RAII

// Inline
//  : 람다 파라미터를 가지고 있는 함수에서 작동하는 기능이다.
//    불필요한 코드를 제거하고 실행하는 메소드 안으로 복사-붙여넣기 하는 기능이다.
inline fun <T> withLock(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

class IncThread(private val lock: Lock): Thread() {
    companion object {
        var n = 0
    }
    /*
    fun run2() {
        // for (i = 1 ; i <= 1000000 ; ++i)
        // Kotlin: Range
        for (e in 1..1000000) {
            lock.lock()
            try {
                ++n
            } finally {
                lock.unlock()
            }
        }
    }
    */

    // withLock에 대한 호출이 발생하면 안된다.
    // 호출하지 말고, 기계어를 실제로 붙여넣어야 한다. - inline
    override fun run() {
        // for (i = 1 ; i <= 1000000 ; ++i)
        // Kotlin: Range
        for (e in 1..1000000) {
            withLock(lock) {
                ++n
            }
        }
    }

    /*
    override fun run() {
        // for (i = 1 ; i <= 1000000 ; ++i)
        // Kotlin: Range
        for (e in 1..1000000) {
            lock.lock()

            ++n

            lock.unlock()
        }
    }
    */
}

fun main(args: Array<String>) {
    val lock = ReentrantLock()

    val t1 = IncThread(lock)
    val t2 = IncThread(lock)

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println(IncThread.n)
}