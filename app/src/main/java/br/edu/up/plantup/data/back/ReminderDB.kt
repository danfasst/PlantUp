package br.edu.up.plantup.data.back

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDB: RoomDatabase(){

    abstract fun reminderDao(): ReminderDao

    companion object{
        fun database(context: Context): ReminderDB {
            return Room.databaseBuilder(
                context.applicationContext,
                ReminderDB::class.java, "reminder.db"
            ).build()
        }
    }
}
