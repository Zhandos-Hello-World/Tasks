package production.zhandos.tasks

import androidx.recyclerview.widget.DiffUtil

class TaskDiffItemCallBack: DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem.taskId == newItem.taskId

    override fun areContentsTheSame(oldItem: Task, newItem: Task) = (oldItem == newItem)
}