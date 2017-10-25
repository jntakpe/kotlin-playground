package playground.kotlin

import org.junit.Test
import rx.observers.TestSubscriber
import java.util.function.Supplier

class WeatherServiceTest {

    @Test
    fun `should return IllegalState error`() {
        listOf(
                java<Weather>(Supplier { "illegal" }, Weather::class.java),
                Supplier { "illegal" }.better<Weather>(),
                Supplier { "illegal" }.betterAgain(),
                Supplier { "illegal" }.betterOnceAgain(),
                Supplier { "illegal" }.wow()
        ).forEach {
            val subscriber = TestSubscriber.create<Weather>()
            it.subscribe(subscriber)
            with(subscriber) {
                assertError(IllegalStateException::class.java)
            }
        }
    }

    @Test
    fun `should return `() {
        listOf(
                java<Weather>(Supplier { Weather() }, Weather::class.java),
                Supplier { Weather() }.better<Weather>(),
                Supplier { Weather() }.betterAgain(),
                Supplier { Weather() }.betterOnceAgain(),
                Supplier { Weather() }.wow()
        ).forEach {
            val subscriber = TestSubscriber.create<Weather>()
            it.subscribe(subscriber)
            with(subscriber) {
                awaitTerminalEvent()
                assertValueCount(1)
            }
        }
    }

    @Test
    fun `should throw error`() {
        listOf(
                java<Weather>(Supplier { throw IllegalArgumentException("sdf") }, Weather::class.java),
                Supplier { throw IllegalArgumentException("sdf") }.better<Weather>(),
                Supplier { throw IllegalArgumentException("sdf") }.betterAgain(),
                Supplier { throw IllegalArgumentException("sdf") }.betterOnceAgain(),
                Supplier { throw IllegalArgumentException("sdf") }.wow()
        ).forEach {
            val subscriber = TestSubscriber.create<Weather>()
            it.subscribe(subscriber)
            with(subscriber) {
                assertError(IllegalArgumentException::class.java)
            }
        }
    }
}