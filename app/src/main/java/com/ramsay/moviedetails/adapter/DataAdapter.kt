package com.ramsay.moviedetails.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramsay.moviedetails.R
import com.ramsay.moviedetails.databinding.ItemLayoutBinding
import com.ramsay.moviedetails.models.response.Result
import com.ramsay.moviedetails.view.MovieDetailsActivity


class DataAdapter :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)


    fun newList(list: List<Result>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemLayoutBinding : ItemLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false)
        return DataViewHolder(itemLayoutBinding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val item = differ.currentList[position]

        holder.onBind(item)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,MovieDetailsActivity::class.java)
            intent.putExtra("title",differ.currentList[position].title)
            intent.putExtra("overview",differ.currentList[position].overview)
            intent.putExtra("originalLanguage",differ.currentList[position].originalLanguage)
            intent.putExtra("poster",differ.currentList[position].posterPath)
            holder.itemView.context.startActivity(intent)
        }

    }


    inner class DataViewHolder(private val itemViewBinding: ItemLayoutBinding):
        RecyclerView.ViewHolder(itemViewBinding.root){


        fun onBind(result: Result) {
            itemViewBinding.result = result
            Glide
                .with(itemViewBinding.ivMovieImage)
                .load("https://image.tmdb.org/t/p/w500/${result.posterPath}")
                .into(itemViewBinding.ivMovieImage)
        }

    }
}