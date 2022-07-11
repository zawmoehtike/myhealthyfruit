package com.zawmoehtike.network.exception

import com.zawmoehtike.network.exception.NetworkException

interface NetworkExceptionToMessageMapper {
  fun map(networkException: NetworkException): String
}