package com.chuanlim.shoestore.models

/**
 * Storing a Shoe item
 * Removing parcelable from the starter object as Rubric doesn't need it.
 */
data class Shoe(var name: String, var size: Double, var company: String, var description: String)