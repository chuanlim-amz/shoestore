package com.chuanlim.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chuanlim.shoestore.databinding.FragmentInstructionBinding

/**
 * WelcomeFragment > InstructionFragment
 */
class InstructionFragment : Fragment() {
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(layoutInflater)

        binding.buttonNextInstruction.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListingFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuLogout -> findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToLoginFragment(true))
        }

        return super.onOptionsItemSelected(item)
    }
}