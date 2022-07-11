package com.zawmoehtike.network

import com.zawmoehtike.network.exception.NetworkException
import com.zawmoehtike.network.exception.NoContentException
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody

/**
 * Created by Vincent on 2019-10-21
 */
fun Call.executeOrThrow(): ResponseBody {

  val response = this.execute()

  return response.getBodyOrThrowNetworkException()
}

fun Response.getBodyOrThrowNetworkException(): ResponseBody {

  if (this.isSuccessful.not()) {

    val errorString = this.body!!.byteStream().bufferedReader().use { it.readText() }
    throw NetworkException(errorString, this.code)
  }
  if (this.code == 204) {
    throw NoContentException()
  }

  val body = this.body ?: throw NetworkException()

  return body
}