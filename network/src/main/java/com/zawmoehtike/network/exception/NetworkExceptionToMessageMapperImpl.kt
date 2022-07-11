package com.zawmoehtike.network.exception

import org.json.JSONObject

class NetworkExceptionToMessageMapperImpl : NetworkExceptionToMessageMapper {
  companion object {
    private const val ERROR_CODE_400 = 400
    private const val ERROR_CODE_401 = 401
    private const val ERROR_CODE_422 = 422
    private const val ERROR_CODE_403 = 403
    private const val ERROR_CODE_404 = 404
    private const val ERROR_CODE_500 = 404
  }

  override fun map(networkException: NetworkException): String {
    when (networkException.errorCode) {
      ERROR_CODE_400 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
      ERROR_CODE_401 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
      ERROR_CODE_422 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
      ERROR_CODE_403 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
      ERROR_CODE_404 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
      ERROR_CODE_500 -> return parseMessageFromErrorBody(networkException.errorBody.toString())
    }
    return "Generic Exception Error"
  }

  private fun parseMessageFromErrorBody(errorBody: String): String {
    val errorJson = JSONObject(errorBody)
    val errorMessage = errorJson.getString("message")
    throw LoginException(errorMessage)
  }
}

