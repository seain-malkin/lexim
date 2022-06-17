package me.seain.lexim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.seain.lexim.databinding.ActivitySearchBinding

class SearchActivity : BaseSearchableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}