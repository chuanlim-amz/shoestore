package com.chuanlim.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



/**
 * ViewModel to store Shoes item which will be used by ShoeList and Save Shoe details Fragments.
 */
class ShoesViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    // Data exposed to UI.
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    // Save Shoe Details
    fun saveShoeDetails(shoe:Shoe) {
        _shoes.value?.add(shoe)
    }
}
