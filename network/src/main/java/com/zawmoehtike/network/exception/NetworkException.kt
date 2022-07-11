package com.zawmoehtike.network.exception

import java.io.IOException

/**
 * Created by Vincent on 2019-10-18
 */
data class NetworkException constructor(
  val errorBody: String? = null,
  var errorCode: Int = 0
) : IOException()
