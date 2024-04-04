package com.example.characterlisttask.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.characterlisttask.R
import com.example.characterlisttask.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {
    private lateinit var binding: FragmentCharacterListBinding
    private lateinit var viewModel: CharacterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CharacterListViewModel::class.java)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characterListResponse.observe(requireActivity()){
            if (it.first().name?.isNotEmpty() == true){
                binding.rcvList.adapter = CharacterListAdapter(it){ id ->
                    val bundle = bundleOf(
                        "id" to id,
                    )
                    findNavController().navigate(R.id.detailsFragment, bundle)
                }
            }
        }
        viewModel.getCharacters()
    }

}