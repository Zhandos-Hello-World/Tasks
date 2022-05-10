package com.zhandos.todolist.feature_note.presentation.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.zhandos.todolist.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}