package com.chuanlim.shoestore

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.chuanlim.shoestore.databinding.ItemShoeBinding
import com.chuanlim.shoestore.models.Shoe

/**
 * Single Shoe Item Layout
 */
class ShoeItem: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ItemShoeBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.item_shoe, this, false)

    /**
     * Populate the layout with Shoe item.
     */
    fun populateLayoutWith(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            tvShoeName.text = shoe.name
            tvSize.text = shoe.size.toString()
            tvCompany.text = shoe.company
            tvDescription.text = shoe.description
        }
    }
}