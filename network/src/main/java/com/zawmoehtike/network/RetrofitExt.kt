package com.zawmoehtike.network

import com.zawmoehtike.network.exception.NetworkException
import com.zawmoehtike.network.exception.NoContentException
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Vincent on 2019-10-21
 */
fun <T> Call<T>.executeOrThrow(): T {

  val response = this.execute()

  return response.getBodyOrThrowNetworkException()
}

fun <T> Response<T>.getBodyOrThrowNetworkException(): T {

  if (this.isSuccessful.not()) {
    val errorString = this.errorBody()!!.byteStream().bufferedReader().use { it.readText() }
    throw NetworkException(errorString, this.code())
  }
  if (this.code() == 204) {
    throw NoContentException()
  }

  val body = this.body() ?: throw NetworkException()

  return body
}