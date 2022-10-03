package org.iesch.a03_ciclo_de_vida_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLODEVIDA_ANDROID","Entramos al metodo onRestart")
    }
}
















