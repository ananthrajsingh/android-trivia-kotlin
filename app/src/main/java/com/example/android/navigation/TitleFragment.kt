package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false)
        binding.playButton.setOnClickListener {
            run {
                TitleFragmentDirections.actionTitleFragmentToGameFragment()
            }
        }
                // TODO (11) Replace action ID with actionTitleFragmentToGameFragment
                // From TitleFragmentDirections
                // We will have to switch this to using an anonymous function, since
                // createNavigateOnClickListener cannot take NavDirections


        setHasOptionsMenu(true)
        return binding.root
    }

    // COMPLETED (04) Override onCreateOptionsMenu
    // Use the passed-in MenuInflater to inflate the overflow_menu
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }
// COMPLETED (05) Override onOptionsItemSelected
    // Return true if NavigationUI.onNavDestinationSelected returns true, else return
    // super.onOptionsItemSelected.
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }

}
