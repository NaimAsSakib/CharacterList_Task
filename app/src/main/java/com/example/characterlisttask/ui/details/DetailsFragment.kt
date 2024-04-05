package com.example.characterlisttask.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.characterlisttask.R
import com.example.characterlisttask.databinding.FragmentCharacterListBinding
import com.example.characterlisttask.databinding.FragmentDetailsBinding
import com.example.characterlisttask.ui.list.CharacterListViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")

        viewModel.characterListResponse.observe(requireActivity()){
            binding.progressBar.visibility = View.GONE
            Glide.with(this)
                .load(it.first().image)
                //.apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.baseline_person_24)
                .into(binding.ivCharacter)

            binding.tvNameValue.text = it.first().name?:""
            binding.tvSpeciesValue.text = it.first().species?:""
            binding.tvGenderValue.text = it.first().gender?:""
            binding.tvHouseValue.text = it.first().house?:""
            binding.tvDobValue.text = it.first().dateOfBirth?:""
            binding.tvDobYearValue.text = it.first().yearOfBirth.toString()
            binding.tvAncestryValue.text = it.first().ancestry?:""
            binding.tvEyeValue.text = it.first().eyeColour?:""
            binding.tvHairValue.text = it.first().hairColour?:""
            binding.tvPatronusValue.text = it.first().patronus?:""
            binding.tvActorValue.text = it.first().actor?:""
            binding.tvAliveValue.text = (it.first().alive?:"").toString()
        }
        viewModel.getDetails(id?:"")
    }
}