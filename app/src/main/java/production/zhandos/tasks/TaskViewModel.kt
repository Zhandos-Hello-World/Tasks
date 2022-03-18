package production.zhandos.tasks

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TaskViewModel(val dao: TaskDao): ViewModel() {
    var newTaskName = ""
    val tasks = dao.getAll()
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask
    fun addTask() {
        viewModelScope.launch {
            if (newTaskName.isNotEmpty()) {
                val task = Task()
                task.taskName = newTaskName
                dao.insert(task)
            }

        }
    }
    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId
    }
    fun onTaskNavigated() {
        _navigateToTask.value = null
    }
}