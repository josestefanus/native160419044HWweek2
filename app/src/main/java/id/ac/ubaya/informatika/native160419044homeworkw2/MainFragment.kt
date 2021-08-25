package id.ac.ubaya.informatika.native160419044homeworkw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val random = Random()
        val random1 = random.nextInt(5)+10
        val random2 = random.nextInt(10)+20
        textNumb1.text = random1.toString()
        textNumb2.text = random2.toString()

        buttonSubmit.setOnClickListener {
            val num1 = Integer.parseInt(textNumb1.text.toString())
            val num2 = Integer.parseInt(textNumb1.text.toString())
            val result = num1 + num2
            val playerAnswer = textAnswer.text.toString()
            var playerScore = 0
            if(result.toString() == playerAnswer) {
                playerScore = 1
            } else {
                playerScore = 0
            }

            val action = MainFragmentDirections.actionGameFragment(playerScore.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}