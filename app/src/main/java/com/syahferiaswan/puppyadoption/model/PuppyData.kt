package com.syahferiaswan.puppyadoption.model

import android.os.Parcel
import android.os.Parcelable

data class PuppyData(
    var name: String?,
    var type: String?,
    var age: Int,
    var image: Int,
    var desc: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeInt(age)
        parcel.writeInt(image)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PuppyData> {
        override fun createFromParcel(parcel: Parcel): PuppyData {
            return PuppyData(parcel)
        }

        override fun newArray(size: Int): Array<PuppyData?> {
            return arrayOfNulls(size)
        }
    }
}