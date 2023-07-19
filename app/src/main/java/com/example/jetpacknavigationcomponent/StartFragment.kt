package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpacknavigationcomponent.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.catButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_startFragment_to_factFragment,
                FactFragment.createArgs(getString(R.string.cat_fact),0))
        }

        binding.hamsterButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_startFragment_to_factFragment,
                FactFragment.createArgs(getString(R.string.hamster_fact),1))
        }
    }
}