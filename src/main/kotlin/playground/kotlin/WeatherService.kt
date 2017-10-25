package playground.kotlin

import rx.Observable
import java.util.function.Supplier

fun <T> java(cache: Supplier<Any>, clazz: Class<T>): Observable<T> {
    try {
        val value = cache.get()
        if (!value.javaClass.isAssignableFrom(clazz)) {
            throw IllegalStateException("Wrong type")
        }
        val weather = value as T
        return Observable.just(weather)
    } catch (e: Exception) {
        return Observable.error(e)
    }
}

inline fun <reified T> Supplier<*>.better(): Observable<T> {
    try {
        val value = get()
        if (value !is T) { // reified
            throw IllegalStateException("Wrong type")
        }
        return Observable.just(value) //smart cast
    } catch (e: Exception) {
        return Observable.error(e)
    }
}

inline fun <reified T> Supplier<*>.betterAgain(): Observable<T> {
    try {
        val value = get()
        if (value !is T) {
            throw IllegalStateException("Wrong type")
        }
        return Observable.just(value)
    } catch (e: Exception) {
        return Observable.error(e)
    }
}

inline fun <reified T> Supplier<*>.betterOnceAgain(): Observable<T> {
    try {
        val value = get() as? T ?: throw IllegalStateException("Wrong type")
        return Observable.just(value)
    } catch (e: Exception) {
        return Observable.error(e)
    }
}

inline fun <reified T> Supplier<*>.wow(): Observable<T> {
    return try {
        Observable.just(get() as? T ?: throw IllegalStateException("Wrong type"))
    } catch (e: Exception) {
        Observable.error(e)
    }
}