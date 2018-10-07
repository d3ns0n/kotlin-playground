import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val times = 10

fun main(args: Array<String>) {
    //runWithCoroutines(::expensiveOperation)
    runWithoutCoroutines(::expensiveOperation)
}

private fun runWithCoroutines(block: suspend (Int) -> Unit) {
    runBlocking {
        repeat(times) {
            // launch a lot of coroutines
            launch {
                block(it)
            }
        }
    }
}

private fun runWithoutCoroutines(block: suspend (Int) -> Unit) {
    runBlocking {
        repeat(times) {
            block(it)
        }
    }
}

private suspend fun expensiveOperation(number: Int) {
    println("Started coroutine #$number...")

    delay(1000)

    println("Coroutine #$number ended.")
}