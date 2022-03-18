package production.zhandos.tasks

import androidx.lifecycle.*
import kotlinx.coroutines.launch
class EditTaskViewModel(taskId: Long, private val dao: TaskDao): ViewModel() {
    val task = dao.getById(taskId)
    private val _navigateToList = MutableLiveData(false)
    val navigateToList: LiveData<Boolean>
        get() = _navigateToList


    fun updateTask() {

        viewModelScope.launch {
            dao.update(task.value!!)
            _navigateToList.value = true
        }
    }
    fun deleteTask() {
        viewModelScope.launch {
            dao.delete(task.value!!)
            _navigateToList.value = true
        }
    }
    fun onNavigatedToList() {
        _navigateToList.value = false
    }

}