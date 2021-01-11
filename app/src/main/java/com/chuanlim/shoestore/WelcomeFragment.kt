package com.chuanlim.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chuanlim.shoestore.databinding.FragmentWelcomeBinding

/**
 * LoginFrament > WelcomeFragment
 */
class WelcomeFragment: Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)
        // Add onclick listener
        binding.welcomeNextButton.setOnClickListener {
            findNavController().navigate(R.id.instructionFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuLogout -> findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment2(true))
        }

        return super.onOptionsItemSelected(item)
    }
}