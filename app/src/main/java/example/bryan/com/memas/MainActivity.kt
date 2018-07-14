package example.bryan.com.memas

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import example.bryan.com.memas.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_fab_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var loggedInToStore: Boolean = false

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Drawer Setup
        val toggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        drawerNavigation.setNavigationItemSelectedListener(this)
        //endregion

        scanItemFAB.visibility = View.GONE
        if (loggedInToStore) {
            scanItemFAB.visibility = View.VISIBLE
            scanItemFAB.setUp()
        }

    }

    private fun FloatingActionButton.setUp() {
        setOnClickListener({
            if (loggedInToStore) {
                //TODO: Start scan.
            }
        })
    }


    override fun onBackPressed() {
        //TODO: Ask user if really want to exit.
    }


    //region Three button menu. Not needed for now.
    //    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }
    //endregion

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.drawerPayments -> {
                Toast.makeText(this, "Go to Payment Methods page!", Toast.LENGTH_SHORT).show()
            }

            R.id.drawerReceipts -> {
                Toast.makeText(this, "Go to Drawer Receipts page!", Toast.LENGTH_SHORT).show()
            }

            R.id.drawerUserSettings -> {
                Toast.makeText(this, "Go to User Settings page!", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {
        fun startActivity() {

        }
    }
}
