package com.example.toodo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentHomesBinding


class HomesFragment : BaseFragment<FragmentHomesBinding>(FragmentHomesBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     binding.txtPersonality.setOnClickListener {
         findNavController().navigate(R.id.action_homesFragment_to_personalityFragment)
     }

        binding.txtWorkTodayS.setOnClickListener {
            findNavController().navigate(R.id.action_homesFragment_to_work_TodayFragment)
        }
    binding.txtSetting.setOnClickListener {

        findNavController().navigate(R.id.action_homesFragment_to_settingsFragment)
    }

    }


}