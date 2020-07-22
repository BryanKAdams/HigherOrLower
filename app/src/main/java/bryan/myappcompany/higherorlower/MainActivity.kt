package bryan.myappcompany.higherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var randomValue = 0
    private val from = 1
    private val to = 20
    private fun generateRandomNumber() {
        randomValue = (from until to).random()
    }

    fun onGuess(view: View) {
        val editText: EditText = findViewById(R.id.playerGuess)
        val playerGuess = editText.text.toString()
        when {
            playerGuess.toInt() == randomValue -> {
                Toast.makeText(this, "You are correct, play again?", Toast.LENGTH_SHORT).show()
                generateRandomNumber()
            }
            playerGuess.toInt() > randomValue -> {
                Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show()
            }
            playerGuess.toInt() < randomValue -> {
                Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateRandomNumber()
        val textView: TextView = findViewById(R.id.textView2)
        textView.text = "Pick a number from $from to $to"

    }
}