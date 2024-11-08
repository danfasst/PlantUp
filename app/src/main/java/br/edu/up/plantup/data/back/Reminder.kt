package br.edu.up.plantup.data.back

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    val day: String,
    val hour: String,
){
    constructor() : this(null, "", "", "")
}
