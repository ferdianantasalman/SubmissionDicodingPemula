package com.example.submissiondicodingpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingpemula.activity.AboutActivity
import com.example.submissiondicodingpemula.adapter.ListRecipeAdapter
import com.example.submissiondicodingpemula.data.RecipeData
import com.example.submissiondicodingpemula.model.Recipe

class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipes: RecyclerView

    private val list = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecipes = findViewById(R.id.rv_recipes)
        rvRecipes.setHasFixedSize(true)

        list.addAll(RecipeData.dataRecipe)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvRecipes.layoutManager = LinearLayoutManager(this)
        val listRecipeAdapter = ListRecipeAdapter(list)
        rvRecipes.adapter = listRecipeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.profile -> {
                val iAbout = Intent(this@MainActivity,
                    AboutActivity::class.java)
                startActivity(iAbout)
            }
        }
    }
}