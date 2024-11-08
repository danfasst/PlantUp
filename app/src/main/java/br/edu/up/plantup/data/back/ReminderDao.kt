package br.edu.up.plantup.data.back

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("select * from reminder")
    fun listReminders(): Flow<List<Reminder>>

    @Upsert
    suspend fun addReminder(reminder: Reminder)

    @Query("select * from reminder where id = :idx")
    suspend fun searchReminder(idx: Int): Reminder

    @Delete
    suspend fun removeReminder(reminder: Reminder)

}
