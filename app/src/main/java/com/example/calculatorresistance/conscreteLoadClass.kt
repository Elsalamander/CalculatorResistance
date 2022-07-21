package com.example.calculatorresistance

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.*
import androidx.navigation.fragment.fragment
import com.example.calculatorresistance.myView.FragmentProva3
import dalvik.system.PathClassLoader
import it.elsalamander.loaderclass.AbstractLoadClass


class conscreteLoadClass : AbstractLoadClass(MyOperation()) {
    companion object{
        object nav_routes {
            const val home = "home"
            const val plant_detail = "plant_detail"
        }
    }

    override fun getNavGraph(navController: NavController, loader: PathClassLoader, fm: FragmentManager, context: AppCompatActivity): NavGraph {
        //FragmentProva::class.java.newInstance()
        //loader.loadClass(FragmentProva3::class.java.name)


        //fm.beginTransaction().add(FragmentProva3(), nav_routes.home)

        val tmp = navController.createGraph(startDestination = nav_routes.home) {
        //    fragment<FragmentProva3>(nav_routes.home) {
        //        label = "prova3"
        //        id
        //    }
        }
        return tmp
    }

    override fun getTitle(): String {
        return "Calculator Resistance"
    }

    override fun getDescription(): String {
        return "Specializzata per resistenze"
    }

}