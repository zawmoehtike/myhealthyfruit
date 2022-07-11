package com.zawmoehtike.domain.exception

/**
 * Created by Vincent on 12/12/18
 */
interface GenericErrorMessageFactory {

  fun getErrorMessage(throwable: Throwable): CharSequence
}

