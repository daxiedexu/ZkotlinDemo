package com.haixu.zkotilndemo

import android.util.Log

private const val TAG = "CustomMath"
class CustomMath {

    fun main(){
        val value = "HelloWord"
        Log.d(TAG, "result -> ${value - "He"}")
        Log.d(TAG, "result -> ${value * 5}")
        Log.d(TAG, "result -> ${value / "d"}")
    }

    operator fun String.minus(right: Any?): String{
        return this.replaceFirst(right.toString(),"")
    }

    operator fun String.times(right: Int): String{
        return (1..right).joinToString("") {this}
    }

    operator fun String.div(right:Any?): Int{
        return this.windowed(right.toString().length,1){
            it == right
        }.count{it}
    }
}