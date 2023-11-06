package com.example.toodo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toodo_app.databinding.FragmentHomesBinding


class HomesFragment : Fragment() {

    lateinit var binding: FragmentHomesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentHomesBinding.inflate(inflater,container,false)
        return (binding.root)
    }

}