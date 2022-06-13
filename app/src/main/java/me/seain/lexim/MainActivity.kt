package me.seain.lexim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import me.seain.lexim.databinding.ActivityMainBinding
import me.seain.lexim.fragment.WordResultFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.let { fm ->
            fm.commit {
                replace(R.id.contentFrame, WordResultFragment.newInstance("test", "test"))
            }
        }
    }
}