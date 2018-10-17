package ex19

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

// lock()과 unlock()을 명시적으로 호출하는 것은 좋지 않다.
//  : 임계 영역에서 예외가 발생할 경우, 데드락의 위험성이 있다.
//   => RAII

fun <T> withLock(lock: Lock, action: () -> T): T {
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