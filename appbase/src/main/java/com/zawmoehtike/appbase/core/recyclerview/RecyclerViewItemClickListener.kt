package com.zawmoehtike.appbase.core.recyclerview

import android.view.View

interface RecyclerViewItemClickListener {

  fun onItemClick(view: View, position: Int)

  fun onItemLongClick(view: View, position: Int)
}

inline fun recyclerViewItemClickListener(
  crossinline onItemLongClick: ((@ParameterName("view") View, @ParameterName("position") Int) -> Unit) = { _, _ -> },
  crossinline onItemClick: ((@ParameterName("view") View, @ParameterName("position") Int) -> Unit)
): RecyclerViewItemClickListener {

  return object : RecyclerViewItemClickListener {
    override fun onItemClick(view: View, position: Int) {
      onItemClick.invoke(view, position)
    }

    override fun onItemLongClick(view: View, position: Int) {
      onItemLongClick.invoke(view, position)
    }

  }
}

