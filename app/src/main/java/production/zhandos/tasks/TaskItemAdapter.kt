package production.zhandos.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import production.zhandos.tasks.databinding.TaskItemBinding

class TaskItemAdapter(private val clickListener: (taskId: Long) -> Unit): ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskItemViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class TaskItemViewHolder(val binding: TaskItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Task, clickListener: (taskId: Long) -> Unit) {
            binding.task = item
            binding.root.setOnClickListener {
                clickListener(item.taskId)
            }
        }

        companion object {
            fun inflate(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }
    }
}