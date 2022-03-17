package production.zhandos.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import production.zhandos.tasks.databinding.TaskItemBinding

class TaskItemAdapter: ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskItemViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class TaskItemViewHolder(val binding: TaskItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Task) {
            binding.task = item
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