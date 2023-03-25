package com.practicum.sharedviewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practicum.sharedviewmodel.SharedViewModel
import com.practicum.sharedviewmodel.databinding.FragmentSaveBinding
import com.practicum.sharedviewmodel.navigator

class SaveFragment : Fragment(){
    lateinit var binding: FragmentSaveBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSaveBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model.data.observe(viewLifecycleOwner, Observer {
            binding.savedTextView.text = it
        })

        binding.nextButton.setOnClickListener {
            val savedText = binding.saveText.text.toString()
            model.setData(savedText)

            navigator().openSecondFragment()
        }
    }

 companion object{
     fun newInstance() = SaveFragment().apply {

     }
 }
}