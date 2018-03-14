package com.example.mbs.pmdmfinal

import android.graphics.Interpolator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.experimental.delay
import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.animation.Animation
import org.jetbrains.anko.sdk25.coroutines.onClick


class Main2Activity : AppCompatActivity() {
    val interpolator = minterpolator(0.2, 20.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        botonf.setOnClickListener(){



            val fragment = BlankFragment()

            val args = Bundle()
            args.putString("111"," HELLO DESDE MAIN ACTIVITY2!!! ")
            fragment.arguments = args
            addFragment(fragment)

            val animacion = AnimationUtils.loadAnimation(this,R.anim.abc_popup_exit)
            animacion.duration = 3000L
            animacion.setInterpolator (interpolator)


            botonf.startAnimation(animacion)

            animacion.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {

                }

                override fun onAnimationStart(animation: Animation?) {

                }

                override  fun onAnimationEnd(Animation: Animation) {
                    botonf.visibility = Button.GONE

                }
            })







            //onAnimationEnd(animacion)

        }

    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.bounce, R.anim.abc_fade_out)
                .replace(R.id.contenido, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }






}
