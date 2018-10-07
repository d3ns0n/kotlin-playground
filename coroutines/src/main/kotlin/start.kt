import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val times = 10

fun main(args: Array<String>) {
    //runWithCoroutines()
    runWithoutCoroutines()
}

private fun runWithCoroutines() {
    runBlocking {
        repeat(times) {
            // launch a lot of coroutines
            launch {
                expensiveOperation(it)
            }
        }
    }
}

private fun runWithoutCoroutines() {
    runBlocking {
        repeat(times) {
            expensiveOperation(it)
        }
    }
}

private suspend fun expensiveOperation(number: Int) {
    println("Started coroutine #$number...")

    delay(1000)

    println("Coroutine #$number ended.")
}