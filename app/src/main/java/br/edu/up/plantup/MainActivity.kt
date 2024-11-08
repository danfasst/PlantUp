package br.edu.up.plantup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.up.plantup.data.ReminderViewModel
import br.edu.up.plantup.data.back.LocalRepository
import br.edu.up.plantup.data.back.ReminderDB.Companion.database
import br.edu.up.plantup.data.back.RemoteRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val isLocal = false

        val db = database(this)

        val localRepository = LocalRepository(db.reminderDao())
        val remoteRepository = RemoteRepository()

        val viewModel: ReminderViewModel
        if (isLocal){
            viewModel = ReminderViewModel(localRepository)
        } else {
            viewModel = ReminderViewModel(remoteRepository)
        }

        setContent {
            PlantUpNavigation(viewModel)
        }

    }
}