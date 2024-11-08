package br.edu.up.plantup.data.back

import kotlinx.coroutines.flow.Flow

class LocalRepository(private val dao: ReminderDao) : IRepository {

    override fun list(): Flow<List<Reminder>> {
        return dao.listReminders()
    }

    override suspend fun add(reminder: Reminder) {
        dao.addReminder(reminder)
    }

    override suspend fun search(idx: Int): Reminder? {
        return dao.searchReminder(idx)
    }

    override suspend fun remove(reminder: Reminder) {
        dao.removeReminder(reminder)
    }

}

