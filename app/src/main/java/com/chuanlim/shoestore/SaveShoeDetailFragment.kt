package com.chuanlim.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.chuanlim.shoestore.databinding.FragmentSaveShoeDetailsBinding
import com.chuanlim.shoestore.models.Shoe
import com.chuanlim.shoestore.models.ShoesViewModel
import kotlinx.android.synthetic.main.fragment_save_shoe_details.*

class SaveShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentSaveShoeDetailsBinding
    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveShoeDetailsBinding.inflate(layoutInflater)

        binding.apply {
            editTextShoeName.doAfterTextChanged { enableSaveBtnOrNot() }
            editTextSize.doAfterTextChanged { enableSaveBtnOrNot() }
            editTextCompany.doAfterTextChanged { enableSaveBtnOrNot() }
            editTextDescription.doAfterTextChanged { enableSaveBtnOrNot() }
        }
        binding.saveShoeBtn.setOnClickListener { saveShoe() }

        // Getting the view model
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        // Setting  the shoes view model
        binding.shoesViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    /**
     * Enable 'SAVE' btn when all the textfields have been filled in
     */
    private fun enableSaveBtnOrNot() {
        //only enable the save btn when all textfields have been filled.
        binding.apply {
            saveShoeBtn.isEnabled = editTextShoeName.text.isNotEmpty()
                    && editTextCompany.text.isNotEmpty()
                    && editTextSize.text.isNotEmpty()
                    && editTextDescription.text.isNotEmpty()
        }
    }

    /**
     * Save new shoe
     */
    private fun saveShoe() {
        viewModel.saveShoeDetails(Shoe(
            editTextShoeName.text.toString(),
            editTextSize.text.toString().toDouble(),
            editTextCompany.text.toString(),
            editTextDescription.text.toString()
        ))
        findNavController().navigate(SaveShoeDetailFragmentDirections.actionSaveShoeDetailFragmentToShoeListingFragment())
    }
}