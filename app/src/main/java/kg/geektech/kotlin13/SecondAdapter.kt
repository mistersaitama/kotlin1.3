package kg.geektech.kotlin13

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlin13.databinding.ItemGoatBinding

class SecondAdapter: RecyclerView.Adapter<SecondAdapter.ViewHolder>() {
    private var list = arrayListOf<Int>()

    class ViewHolder(private var binding: ItemGoatBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(i: Int) {
            binding.imageOriginal.setImageResource(i)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGoatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList (list: ArrayList<Int>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}