package come.example.core

/**
 * Status of a resource that is provided to the UI.
 *
 *
 * These are usually created by the Repository classes where they return
 * `LiveData<Resource<T>>` to pass back the latest businessRewards to the UI with its fetch status.
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING;

    fun isSuccess() = this == SUCCESS
    fun isError() = this == ERROR
    fun isLoading() = this == LOADING
}
