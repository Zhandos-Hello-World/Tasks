package production.zhandos.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import production.zhandos.tasks.databinding.FragmentTaskBinding

class TaskFragment: Fragment() {
    private var _binding: FragmentTaskBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        val view = binding.root


        val application = requireNotNull(this.activity).application
        val dao = TaskDataBase.getInstance(application).taskDao
        val factory = TaskViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }
}