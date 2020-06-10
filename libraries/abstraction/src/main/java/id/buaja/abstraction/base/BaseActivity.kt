package id.buaja.abstraction.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

abstract class BaseActivity : AppCompatActivity() {
    abstract fun contentView(): Int
    abstract fun initObservable()
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
        initObservable()
        initView()
    }
}