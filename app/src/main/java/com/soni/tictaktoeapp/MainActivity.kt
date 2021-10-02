package com.soni.tictaktoeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
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

        checkwinner()
    }

    fun checkwinner(){

        var winer = -1
        //row 1
        if(player1.contains(1)&& player1.contains(2) && player1.contains(3)){
            winer = 1
        }
        if(player2.contains(1)&& player2.contains(2) && player2.contains(3)){
            winer = 2
        }
        //row 2
        if(player1.contains(4)&& player1.contains(5) && player1.contains(6)){
            winer = 1
        }
        if(player2.contains(4)&& player2.contains(5) && player2.contains(6)){
            winer = 2
        }
        //row 3
        if(player1.contains(7)&& player1.contains(8) && player1.contains(9)){
            winer = 1
        }
        if(player2.contains(7)&& player2.contains(8) && player2.contains(9)){
            winer = 2
        }
        //col 1
        if(player1.contains(1)&& player1.contains(4) && player1.contains(7)){
            winer = 1
        }
        if(player2.contains(1)&& player2.contains(4) && player2.contains(7)){
            winer = 2
        }
        //col 2
        if(player1.contains(2)&& player1.contains(5) && player1.contains(8)){
            winer = 1
        }
        if(player2.contains(2)&& player2.contains(5) && player2.contains(8)){
            winer = 2
        }
        //col 3
        if(player1.contains(3)&& player1.contains(6) && player1.contains(9)){
            winer = 1
        }
        if(player2.contains(3)&& player2.contains(6) && player2.contains(9)){
            winer = 2
        }

        if ( winer == 1){
            Toast.makeText(this, "Player 1 win the game.", Toast.LENGTH_LONG).show()
        }else if (winer == 2){
            Toast.makeText(this, "Player 2 win the game.", Toast.LENGTH_LONG).show()
        }
    }
}
