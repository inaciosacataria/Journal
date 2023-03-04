package com.decode.journal.model

import android.graphics.drawable.Drawable
import android.icu.text.CaseMap.Title
import com.decode.journal.R
import java.time.Year


data class Date(var month: String, var day: Int, var dayOfWeek: String)
data class Note(
    var title: String,
    var description: String,
    var images: String? = "",
    var date: Date
)

data class Notes(
    var month: String,
    var year: Int,
    var noteList: List<Note>
) {

}

object NotesData{
    var notes = Notes(
        "October",
        2022,
        noteList = listOf<Note>(
            Note(
                title = "Note",
                description = "Need to normalize my sleep routine to fall asleep faster and wake up earlier. I should try drinking relaxing tea before going to bed, lightong some candles or reading a physical book.",
                date = Date("October", 11, "TUE")
            ),
            Note(
                title = "WHAT I WAS GRATEFUL FOR",
                description = "Working out in the morning-it makes me feel energized and happy.",
                date = Date("October", 10, "MON"),
                images = (R.drawable.ic_launcher_background).toString()
            )
        )
    )
}

object NoteUseCase {
    var list: List<Notes> = listOf<Notes>(
        NotesData.notes
    )
}
