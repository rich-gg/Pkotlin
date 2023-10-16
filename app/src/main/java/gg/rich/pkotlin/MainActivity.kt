@file:Suppress("DEPRECATION")

package gg.rich.pkotlin

import gg.rich.pkotlin.sketch.Pkotlin_Main
//import android.app.ActionBar.LayoutParams
import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import processing.android.CompatUtils
import processing.android.PFragment
import android.view.WindowManager.LayoutParams.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // FrameLayoutを作成
        val frame = FrameLayout(this)
        frame.id = CompatUtils.getUniqueViewId()
        setContentView(
            frame,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )

        supportActionBar?.hide()

        this.window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )

        // PAppletクラスを継承したSketchクラスをNewする
        val sketch = Pkotlin_Main()
        // PFragmentで描画
        val fragment = PFragment(sketch)
        fragment.setView(frame, this)
    }
}