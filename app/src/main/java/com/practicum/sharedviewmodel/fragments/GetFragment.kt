package com.practicum.sharedviewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practicum.sharedviewmodel.SharedViewModel
import com.practicum.sharedviewmodel.databinding.FragmentGetBinding
import com.practicum.sharedviewmodel.navigator

class GetFragment : Fragment() {
    lateinit var binding: FragmentGetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.data.observe(viewLifecycleOwner, Observer {
            binding.loadedText.text = it
        })

        binding.backButton.setOnClickListener {
            navigator().goBack()
        }
    }

    companion object{
        fun newInstance() = GetFragment().apply {

        }
    }
}