package br.edu.up.plantup.data.back

import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun list(): Flow<List<Reminder>>

    suspend fun search(idx: Int): Reminder?

    suspend fun add(reminder: Reminder)

    suspend fun remove(reminder: Reminder)

}
