package yusufs.turan.superheroes
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import yusufs.turan.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var heroList:ArrayList<Superkahraman>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ironman=Superkahraman("Iron Man", "Billionaire", R.drawable.indir)
        val spiderman=Superkahraman("Spider Man", "Student", R.drawable.sm)
        val hulk=Superkahraman("Hulk", "Nuclear Physicist", R.drawable.hulk)
        val cpamerica=Superkahraman("Captain America", "Former Soldier", R.drawable.ka)

        heroList= arrayListOf(ironman,spiderman,hulk,cpamerica)
        

        val adapter= SuperkahramanAdapter(heroList)
        binding.heroRecycler.layoutManager=LinearLayoutManager(this)
        binding.heroRecycler.adapter= adapter
    }

}