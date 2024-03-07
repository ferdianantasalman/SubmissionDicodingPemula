package com.example.submissiondicodingpemula.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.submissiondicodingpemula.R
import com.example.submissiondicodingpemula.databinding.ActivityDetailBinding
import com.example.submissiondicodingpemula.databinding.ActivitySplashBinding

class DetailActivity : AppCompatActivity() {

//    private lateinit var tvNameDetail: TextView
//    private lateinit var tvDescriptionDetail: TextView
//    private lateinit var tvIngredientDetail: TextView
//    private lateinit var tvStepDetail: TextView
//    private lateinit var ivImageDetail: ImageView
//    private lateinit var btnShare: Button

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_INGREDIENT = "extra_ingredient"
        const val EXTRA_STEP = "extra_step"
        const val EXTRA_IMAGE = "extra_image"

    }

//    fun instanceView() {
//        tvNameDetail = findViewById(R.id.tv_name_detail)
//        tvDescriptionDetail = findViewById(R.id.tv_description_detail)
//        tvIngredientDetail = findViewById(R.id.tv_ingredient_detail)
//        tvStepDetail = findViewById(R.id.tv_step_detail)
//        ivImageDetail = findViewById(R.id.iv_image_detail)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_detail)

//        instanceView()

        val appBar = supportActionBar
        appBar!!.title = "Detail Resep"
        appBar.setDisplayHomeAsUpEnabled(true)

        val nameDetail = intent.getStringExtra(EXTRA_NAME)
        val descriptionDetail = intent.getStringExtra(EXTRA_DESCRIPTION)
        val ingredientDetail = intent.getStringExtra(EXTRA_INGREDIENT)
        val stepDetail = intent.getStringExtra(EXTRA_STEP)
        val imageDetail = intent.getIntExtra(EXTRA_IMAGE, 0)


        if (nameDetail != null) {
            Log.i("NAMEDETAIL", nameDetail)

            binding.tvNameDetail.text = nameDetail
            binding.tvDescriptionDetail.text = descriptionDetail
            binding.tvIngredientDetail.text = ingredientDetail
            binding.tvStepDetail.text = stepDetail
            binding.ivImageDetail.setImageResource(imageDetail)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.share -> {
                val recipeShare = Intent()
                recipeShare.action = Intent.ACTION_SEND
                recipeShare.putExtra(Intent.EXTRA_TEXT, "Ini adalah hasil share dari resep: ${binding.tvNameDetail.text}")
                recipeShare.type = "text/plain"
                startActivity(Intent.createChooser(recipeShare, "Share To:"))
            }
        }
    }
}