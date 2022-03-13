package production.zhandos.tasks

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(val dao: TaskDao): ViewModel() {
    var newTaskName = ""
    private val tasks = dao.getAll()
    val taskString = Transformations.map(tasks) {
            tasks -> formatTasks(tasks)
    }
    private fun formatTasks(tasks: List<Task>): String {
        return tasks.fold("") {
                str, item -> str + "\n" + formatTask(item)
        }
    }
    private fun formatTask(task: Task): String {
        var str = "ID: ${task.taskId}"
        str += "\n" + "Name: ${task.taskName}"
        str += "\n" + "Complete: ${task.isDone}\n"
        return str
    }


    fun addTask() {
        viewModelScope.launch {
            if (newTaskName.isNotEmpty()) {
                val task = Task()
                task.taskName = newTaskName
                dao.insert(task)
            }

        }
    }
}