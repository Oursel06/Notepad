package androidkotlin.notepad

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteDialogFragment(val notetitle: String = "") : DialogFragment() {
    interface ConfirmDeleteDialogListener{
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Suppression")
            .setMessage("êtes-vous sûr de vouloir supprimer la note $notetitle ?")
            .setPositiveButton("Supprimer",
                DialogInterface.OnClickListener{dialog, id -> listener?.onDialogPositiveClick()})
            .setNegativeButton("Annuler",
                DialogInterface.OnClickListener{dialog, id -> listener?.onDialogNegativeClick()})
        return builder.create()
    }
}