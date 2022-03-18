package production.zhandos.tasks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        val adapter = TaskItemAdapter{
            viewModel.onTaskClicked(taskId = it)
        }
        binding.tasksList.adapter = adapter
        viewModel.tasks.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }
        viewModel.navigateToTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                val action = TaskFragmentDirections.actionTaskFragmentToEditTaskFragment(it)
                this.findNavController().navigate(action)
                viewModel.onTaskNavigated()
            }
        })
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}