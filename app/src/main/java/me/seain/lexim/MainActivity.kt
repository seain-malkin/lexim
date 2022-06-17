package me.seain.lexim

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import me.seain.lexim.databinding.ActivityMainBinding
import me.seain.lexim.fragment.WordResultFragment

@AndroidEntryPoint
class MainActivity : BaseSearchableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.activityTemplate.appbar)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            // TODO: Add fab action
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.actionSearch)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            isIconifiedByDefault = false
        }
        return true
    }
}