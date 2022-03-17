import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class LIFOTest {

    @Test
    fun peek() {
        var lifo= LIFO<Int>(0)
        assertEquals(null, lifo.peek())
    }

    @Test
    fun poll() {
        var lifo= LIFO<Int>(1)
        lifo.offer(1)
        lifo.poll()
        assertEquals(lifo.poll(), null)
    }

    @Test
    fun offer() { //проверка на добавление эл-та
        //var stack = Stack<Int>()
        //stack.push(1)
        var lifo= LIFO<Int>(4)
        lifo.offer(4)
        assertEquals(4, lifo.remove())
    }
}