package com.haixu.zkotilndemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cale("3","-","3")
        val customMath = CustomMath()
        customMath.main()
    }

    /**
     * 四则运算
     */
    private fun cale(vararg args: String){
        if (args.size != 3){
            return showHelp()
        }

        val operator = mapOf(
            "+" to ::add,
            "-" to ::del
        )
        
        val op = args[1]
        val opFunc = operator[op] ?: return showHelp()
        Log.d(TAG, "input${args.joinToString(",")}")
        Log.d(TAG, "result ${opFunc(args[0].toInt(), args[2].toInt())}")
    }

    private fun add(p1: Int, p2: Int): Int{
        return p1 + p2
    }

    private fun del(p1: Int, p2: Int): Int{
        return p1 - p2
    }

    private fun showHelp(){
        Log.d(TAG, """
            input size should is 3
            demo input value is 4*5
            """.trimIndent()
        )
    }
}