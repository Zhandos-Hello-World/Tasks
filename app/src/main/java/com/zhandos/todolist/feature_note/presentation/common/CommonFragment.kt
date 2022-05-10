package com.zhandos.todolist.feature_note.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.zhandos.todolist.databinding.FragmentCommonBinding
import com.zhandos.todolist.feature_note.presentation.common.components.NoteItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CommonFragment : Fragment() {
    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModel: CommonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommonBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = NoteItemAdapter()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.noteItems.adapter = adapter

        viewModel.all.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        binding.addBtn.setOnClickListener{
            val navigation = view.findNavController()
            val destination = CommonFragmentDirections.actionCommonFragmentToAddFragment()
            navigation.navigate(destination)
        }

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}