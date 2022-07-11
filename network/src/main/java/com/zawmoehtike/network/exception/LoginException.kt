package com.zawmoehtike.network.exception

data class LoginException(
  val errorMessage: String
) : Throwable()