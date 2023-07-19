package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpacknavigationcomponent.databinding.FragmentFactBinding

class FactFragment : Fragment() {



    private lateinit var binding: FragmentFactBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fact: String = arguments?.getString(ARGS_FACT) ?: ""
        val factId: Int = arguments?.getInt(ARGS_FACT_ID) ?: 0


        binding.fact.text = fact

        val imageId = if (fact.equals(getString(R.string.cat_fact))) R.drawable.barsik else R.drawable.hamsters

        binding.imageButton.setOnClickListener {
            findNavController().navigate(R.id.action_factFragment_to_imageFragment,
                ImageFragment.createArgs(imageId))
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    companion object {
        private const val ARGS_FACT = "fact"
        const val ARGS_FACT_ID = "fact_id"

        fun createArgs(fact: String, factId: Int) = bundleOf(
            ARGS_FACT to fact,
            ARGS_FACT_ID to factId
        )

    }

}