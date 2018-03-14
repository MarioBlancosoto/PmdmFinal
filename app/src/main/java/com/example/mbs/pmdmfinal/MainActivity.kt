package com.example.mbs.pmdmfinal

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI


class MainActivity : AppCompatActivity() {


    private val uiContext: CoroutineContext = UI
    private val contextoActual: CoroutineContext = CommonPool
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val interpolator = minterpolator(0.2, 20.0)

   boton.setOnClickListener(){
       animarGear1().start()
       animarGear2().start()
       animarGear3().start()




       barraProgreso()

    val animacion = AnimationUtils.loadAnimation(this,R.anim.bounce)
       animacion.setInterpolator (interpolator)
       boton.startAnimation(animacion)


   }



    }


    private fun animarGear1() = launch(uiContext) {



            val objectAnimator = ObjectAnimator.ofFloat(
                    gear1,
                    "rotation",

                    360f)
            objectAnimator.duration = 30000L
            objectAnimator.interpolator



            objectAnimator.start()
        }

    private fun animarGear2() = launch(uiContext) {



        val objectAnimator = ObjectAnimator.ofFloat(
                gear2,
                "rotation",
                -360f)
        objectAnimator.duration = 30000L

        
        objectAnimator.start()

    }

    private fun animarGear3() = launch(uiContext) {



        val objectAnimator = ObjectAnimator.ofFloat(
                gear3,
                "rotation",
                360f)
        objectAnimator.duration = 30000L
        objectAnimator.interpolator

        objectAnimator.start()

    }





    private fun barraProgreso() = launch(uiContext) {

        for (i in 0 until  105) {
          if(i ==10){
              text.setText(" Parece que va a tardar un poquito...")
          }else if(i ==30){
              text.setText("Vamos alla...")
          }else if(i == 50){
              text.setText("Ya queda menos")
          }else if(i == 70){
              text.setText("En nada terminamos...")
          }else if(i == 100){
              text.setText("Listo!!")
         setupWindowAnimations()

          }

        barra.setProgress(i)
            delay(100) // w
        }

    }

   fun setupWindowAnimations()
    {
        val segundaPantalla = Intent(this,Main2Activity::class.java)

        startActivity(segundaPantalla)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    

}
