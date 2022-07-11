package com.zawmoehtike.domain.helper

/**
 * Created by Vincent on 1/24/20
 */
sealed class ProgressableObject<T> {

  data class Progressing<T>(val progress: Float) : ProgressableObject<T>()

  data class Completed<T>(val value: T) : ProgressableObject<T>()

  data class Error<T>(val error: Exception) : ProgressableObject<T>()

}