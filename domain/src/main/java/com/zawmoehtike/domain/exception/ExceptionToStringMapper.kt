package com.zawmoehtike.domain.exception

import com.zawmoehtike.domain.mapper.UnidirectionalMap

/**
 * Created by Vincent on 11/27/19
 */
interface ExceptionToStringMapper : UnidirectionalMap<Throwable, String>