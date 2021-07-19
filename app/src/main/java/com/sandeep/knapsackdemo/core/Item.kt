package com.sandeep.knapsackdemo.core

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Item(val name: String, val weight: Int, val value: Double, val icon: Int):Parcelable{
    override fun toString(): String {
        return "Name : $name Value is : $value weight: $weight\n"
    }
}