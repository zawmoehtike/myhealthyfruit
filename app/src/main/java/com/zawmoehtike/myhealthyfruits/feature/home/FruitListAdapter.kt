package com.zawmoehtike.myhealthyfruits.feature.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawmoehtike.appbase.core.recyclerview.BaseRecyclerViewAdapter
import com.zawmoehtike.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.myhealthyfruits.R
import com.zawmoehtike.myhealthyfruits.databinding.ViewHolderFruitBinding

class FruitListAdapter(
    val listener: FruitListListener
) : BaseRecyclerViewAdapter<FruitModel, FruitListAdapter.FruitListViewHolder>(
    diffCallback = diffCallBackWith(
        areItemTheSame = { item1, item2 ->
            item1.id == item2.id
        },
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        }
    )
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FruitListViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_fruit, parent, false)

        return FruitListViewHolder(view, listener)
    }

    interface FruitListListener {
        fun onClickFruit(client: FruitModel)
    }

    class FruitListViewHolder(
        itemView: View,
        listener: FruitListListener
    ) : BaseViewHolder<FruitModel>(itemView) {

        private val binding = ViewHolderFruitBinding.bind(itemView)

        private var item: FruitModel? = null

        init {
            binding.root.setOnClickListener {
                if (item != null) listener.onClickFruit(client = item!!)
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(item: FruitModel) {
            this.item = item

            binding.tvTitle.text = item.name
            binding.tvSubtitle.text = "Family: ${item.family}"
            binding.tvDescription.text = "Order: ${item.order} Genus: ${item.genus}"
        }
    }
}