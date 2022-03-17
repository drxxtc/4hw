import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
internal class FIFOTest {


    @Test
    fun remove() { //проверка на обработку пустой очереди
        var fifo= FIFO<Int>(0)
        assertThrows<NoSuchElementException> {
            fifo.remove()
        }
    }
    @Test
    fun peek() {  //получение головы очереди
        var fifo= FIFO<Int>(0)
        assertEquals(null, fifo.peek())
        var fifo1= FIFO<Int>(1)
        fifo1.offer(5)
        assertEquals(5, fifo1.peek())
    }

    @Test
    fun offer() { //проверка на добавление эл-та
        var fifo= FIFO<Int>(4)
        fifo.offer(4)
        assertEquals(4, fifo.remove())
    }
}