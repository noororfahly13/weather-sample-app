package com.example.core.extensions

import androidx.lifecycle.ViewModel
import com.example.core.Resource
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat

open class BaseViewModel : ViewModel() {

}

suspend inline fun <T> Flow<Resource<T>>.collect(
    crossinline action: suspend (value: Resource<T>) -> Unit
): Unit =
    collect { value ->
        action(value)
    }

fun Long.toDay(): String? {
    val format = SimpleDateFormat("EEEE")
    return format.format(this * 1000L)
}