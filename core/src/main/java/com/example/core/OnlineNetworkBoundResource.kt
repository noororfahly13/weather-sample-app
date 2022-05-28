package com.example.core

import com.example.core.network.response.ApiEmptyResponse
import com.example.core.network.response.ApiErrorResponse
import com.example.core.network.response.ApiResponse
import com.example.core.network.response.ApiSuccessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

abstract class OnlineNetworkBoundResource<ResultType, RequestType>(private val withProgress: Boolean = true, val isConnected: Boolean = true) {

    private var result: Flow<Resource<ResultType>>

    init {
        result = flow<Resource<ResultType>> {

            if (withProgress)
                emit(Resource.loading(null))

            val apiResponse: ApiResponse<RequestType>
            val call = createCall().first()
            apiResponse = call ?: ApiErrorResponse("Unknown error")

            apiResponse.let {
                when (it) {
                    is ApiSuccessResponse -> {

                        val resultData = processResponse(it)
                        emit(Resource.success(convertResult(resultData)))
                    }
                    is ApiEmptyResponse -> {
                        emit(Resource.success(null))
                    }
                    is ApiErrorResponse -> {

                        onFetchFailed()

                        emit(
                            Resource.error(
                                it.errorMessage,
                                null,
                                it.code,
                                it.rawResponse
                            )
                        )
                    }
                }
            }

        }.catch { error ->
            Timber.e(error)
            emit(Resource.error("", null, -1, null))
        }.flowOn(Dispatchers.IO)
    }


    protected abstract fun onFetchFailed()

    fun asFlowData() = result

    protected open fun processResponse(response: ApiSuccessResponse<RequestType>): RequestType {
        print("response.body" + response.body.toString())
        return response.body
    }

    protected abstract suspend fun convertResult(data: RequestType): ResultType
    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>?>
}
