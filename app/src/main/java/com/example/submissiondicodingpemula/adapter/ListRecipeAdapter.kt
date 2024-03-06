package com.example.submissiondicodingpemula.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingpemula.R
import com.example.submissiondicodingpemula.activity.DetailActivity
import com.example.submissiondicodingpemula.model.Recipe

class ListRecipeAdapter(private val listRecipe: ArrayList<Recipe>) : RecyclerView.Adapter<ListRecipeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listRecipe.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val recipe = listRecipe[position]

        holder.imgPhoto.setImageResource(recipe.photo!!)
        holder.tvName.text = recipe.name
        holder.tvDescription.text = recipe.description

        Log.i("FRD", recipe.toString())

        val mainContext = holder.itemView.context

        holder.itemView.setOnClickListener {

            val intentDetail = Intent(mainContext, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_NAME, recipe.name)
            intentDetail.putExtra(DetailActivity.EXTRA_DESCRIPTION, recipe.description)
            intentDetail.putExtra(DetailActivity.EXTRA_INGREDIENT, recipe.ingredient)
            intentDetail.putExtra(DetailActivity.EXTRA_STEP, recipe.step)
            intentDetail.putExtra(DetailActivity.EXTRA_IMAGE, recipe.photo)

            mainContext.startActivity(intentDetail)
        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}