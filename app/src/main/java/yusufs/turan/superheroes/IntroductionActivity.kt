package yusufs.turan.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import yusufs.turan.superheroes.databinding.ActivityIntroductionBinding


class IntroductionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityIntroductionBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //val fromAdapter=intent
        //fromAdapter.getSerializableExtra("selectedHero",Superkahraman::class.java)
        //val Selection = fromAdapter.getSerializableExtra("selectedHero") as Superkahraman

        var Selection=MySingleton.heroSelect

        Selection?.let {
            binding.imageView.setImageResource(Selection.pic)
            binding.nameText.text= "Name: ${Selection.name}"
            binding.jobText.text= "Job: ${Selection.job}"
        }

        /*binding.imageView.setImageResource(Selection.pic)
        binding.nameText.text= "Name: ${Selection.name}"
        binding.jobText.text= "Job: ${Selection.job}"*/
    }
}