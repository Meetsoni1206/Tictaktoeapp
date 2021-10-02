package com.soni.tictaktoeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.soni.tictaktoeapp.R.color.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buclick(view: android.view.View) {

        val idselected = view as Button

        var cellId = 0
        when(idselected.id){
            R.id.b1 -> cellId = 1
            R.id.b2 -> cellId = 2
            R.id.b3 -> cellId = 3
            R.id.b4 -> cellId = 4
            R.id.b5 -> cellId = 5
            R.id.b6 -> cellId = 6
            R.id.b7 -> cellId = 7
            R.id.b8 -> cellId = 8
            R.id.b9 -> cellId = 9
        }


//        Log.d("buclick", idselected.id.toString())
//        Log.d("buclick", cellId.toString())
        playgame(cellId, idselected)
    }
    var activeplayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()


    @SuppressLint("ResourceAsColor")
    fun playgame(cellId:Int, idselected:Button){

        if (activeplayer == 1){
            idselected.text = "X"
            idselected.setBackgroundColor(R.color.blue)
            player1.add(cellId)
            activeplayer = 2
        }else{
            idselected.text = "O"
            idselected.setBackgroundColor(R.color.darkGreen)
            player2.add(cellId)
            activeplayer = 1
        }
        idselected.isEnabled = false
    }
}