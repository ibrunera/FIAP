package br.com.fiap.nac01.rm81214

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val imgs = intArrayOf(
        R.drawable.p0,
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6
    )

    var passa = imgs.size

    var volta = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun voltarImg(view: View){

        if(passa>0){
            passa=passa-1
            imgFoto.setImageResource(imgs[passa])

        }else{
            passa=imgs.size
            imgFoto.setImageResource(imgs[0])
        }
    }

    fun passarImg(view: View){

        if(volta<imgs.size){
            imgFoto.setImageResource(imgs[volta])
            volta=volta+1
        }else{
            volta=0
            imgFoto.setImageResource(imgs[0])
        }
    }


}
