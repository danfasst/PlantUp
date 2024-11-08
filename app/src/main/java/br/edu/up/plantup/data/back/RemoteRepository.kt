package br.edu.up.plantup.data.back

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class RemoteRepository() : IRepository {

    var db = FirebaseFirestore.getInstance()
    var reminderCollection = db.collection("reminders")

    override fun list(): Flow<List<Reminder>> = callbackFlow {

        val listener = reminderCollection.addSnapshotListener { data, errors ->
            if (errors != null) {
                close(errors)
                return@addSnapshotListener
            }
            if (data != null) {
                val reminders = data.documents.mapNotNull { data ->
                    data.toObject(Reminder::class.java)
                }
                trySend(reminders).isSuccess
            }
        }
        awaitClose { listener.remove() }
    }

    override suspend fun add(reminder: Reminder) {

        val document: DocumentReference
        if (reminder.id == null) {
            reminder.id = getMaxId()
            document = reminderCollection.document(reminder.id.toString())
        } else {
            document = reminderCollection.document(reminder.id.toString())
        }
        document.set(reminder).await()
    }

    private suspend fun getMaxId(): Int {

        val data = reminderCollection.get().await()
        val maxId = data.documents.mapNotNull {
            it.getLong("id")?.toInt()
        }.maxOrNull() ?: 0

        return maxId + 1
    }

    override suspend fun search(idx: Int): Reminder? {

        val data = reminderCollection.document(idx.toString()).get().await()

        return data.toObject(Reminder::class.java)
    }

    override suspend fun remove(reminder: Reminder) {
        reminderCollection.document(reminder.id.toString()).delete().await()
    }
}
