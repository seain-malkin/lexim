package me.seain.lexim

import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseSearchableActivity : AppCompatActivity() {

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