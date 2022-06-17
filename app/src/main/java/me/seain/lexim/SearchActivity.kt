package me.seain.lexim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import me.seain.lexim.databinding.ActivitySearchBinding
import me.seain.lexim.fragment.WordResultFragment

class SearchActivity : BaseSearchableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchBinding.inflate(layoutInflater)
        setSupportActionBar(binding.activityTemplate.appbar)
        setContentView(binding.root)
        supportFragmentManager.let { fm ->
            fm.commit {
                replace(R.id.contentFrame, WordResultFragment.newInstance("test", "test"))
            }
        }
    }
}