package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import com.example.pranit.mvpshop.data.models.Variant

/**
 * Created by pranit on 13/1/18.
 */
@Dao interface VariantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVarient(varient : Variant)
}