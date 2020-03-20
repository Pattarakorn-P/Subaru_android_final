package com.example.myapplicationfirebase2

class Sti(var name: String, var sales: Float) {
    companion object {
        fun getSampleStiData(size: Int): ArrayList<Sti> {
            val subaru: ArrayList<Sti> = ArrayList()
            for (i in 0 until size) {
                subaru.add(Sti("Sales $i", Math.random().toFloat() * 100))
            }
            return subaru
        }
    }
}