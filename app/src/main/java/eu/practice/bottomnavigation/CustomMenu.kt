package eu.practice.menuandoptionmenu

import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast.*
import eu.practice.bottomnavigation.R

class CustomMenu {


    fun customMenu(context: Context , view: View){
        val pop = PopupMenu(context , view)
        pop.inflate(R.menu.toolbar_menu)
        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.Help -> { makeText(context,"Help Clicked" , LENGTH_LONG).show()
                    true
                }
                R.id.aboutUs -> { makeText(context,"About Us Clicked" , LENGTH_LONG).show()
                    true
                }
                else -> { false }

            }
        }

        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMPopup.isAccessible = true
            val mPopup = fieldMPopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setFoeceShowIcon",Boolean::class.java)
                .invoke(mPopup , true)


        }
        catch (e:Exception){
            e.printStackTrace()
        }
        finally {
            pop.show()
        }



    }

}