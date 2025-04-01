package yusufs.turan.superheroes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yusufs.turan.superheroes.databinding.RecyclerRowBinding

class SuperkahramanAdapter(val heroList: ArrayList<Superkahraman>) : RecyclerView.Adapter<SuperkahramanAdapter.SuperHeroViewHolder>() {

    class SuperHeroViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperHeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text=heroList[position].name
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,IntroductionActivity::class.java)
            intent.putExtra("selectedHero",heroList[position])
            holder.itemView.context.startActivity(intent)
        }
    }


}