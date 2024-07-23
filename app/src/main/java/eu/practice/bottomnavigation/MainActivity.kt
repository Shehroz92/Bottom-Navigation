package eu.practice.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import eu.practice.menuandoptionmenu.CustomMenu

class MainActivity : AppCompatActivity() {

    private var bnView: BottomNavigationView? = null
    private var toolbar :Toolbar? =null
    val customMenu = CustomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbarNavigation)
        setSupportActionBar(toolbar)
        val showPopup = findViewById<Button>(R.id.toolbar_menu_btn)

        showPopup.setOnClickListener {
            customMenu.customMenu(this , it)
        }

        bnView = findViewById(R.id.BottomNavigationView)
        loadFrag(HomeFragment(),0)

        bnView?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle home navigation
                loadFrag( HomeFragment() ,0)
                }
                R.id.search -> {
                    // Handle search navigation
                    loadFrag(SearchFragment() , 1)
                }
                R.id.nav_settings -> {
                    // Handle settings navigation
                    loadFrag(SettingsFragment() , 1)
                }
                R.id.nav_contacts -> {
                    // Handle contacts navigation
                    loadFrag(ContactsFragment() , 1)
                }
                R.id.nav_MyProfile -> {
                    // Handle my profile navigation
                    loadFrag(MyProfileFragment() , 1)
                }
            }
            true
        }
    }

    private fun loadFrag(fragment: Fragment , int :Int){
        val fm :  FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        if (int == 0){
            ft.add(R.id.container , fragment)
        }else{
            ft.replace(R.id.container , fragment)
        }

        ft.commit()
    }

}