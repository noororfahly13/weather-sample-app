package come.example.core.extensions

import androidx.lifecycle.ViewModel
import come.example.core.Resource
import kotlinx.coroutines.flow.Flow

open class BaseViewModel : ViewModel() {

}

suspend inline fun <T> Flow<Resource<T>>.collect(
    crossinline action: suspend (value: Resource<T>) -> Unit
): Unit =
    collect { value ->
        action(value)
    }