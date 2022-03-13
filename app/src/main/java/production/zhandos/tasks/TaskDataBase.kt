package production.zhandos.tasks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDataBase: RoomDatabase() {
    abstract val taskDao: TaskDao

    companion object {
        @Volatile
        var INSTANCE: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataBase::class.java,
                        "tasks_database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}