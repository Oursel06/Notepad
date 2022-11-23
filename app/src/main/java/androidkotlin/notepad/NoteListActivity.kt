package androidkotlin.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        notes = mutableListOf<Note>()
        notes.add(Note("Note 1", "test test"))
        notes.add(Note("Mémo test", "ceci est une note de test"))
        notes.add(Note("bla bla", "abcdefghijklmnopqrstuvwxyz"))

        adapter = NoteAdapter(notes, this)

        val recyclerView = findViewById(R.id.recycler_View) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View) {
        if(view.tag != null){
            showNoteDetail(view.tag as Int)
        }
    }

    fun showNoteDetail(noteIndex: Int){
        val note = notes[noteIndex]
        val intent = Intent(this, NoteDetailActivity:: class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, noteIndex)
        startActivity(intent)
    }
}