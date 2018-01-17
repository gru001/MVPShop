package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pranit.mvpshop.TABLE_VARIANT
import com.example.pranit.mvpshop.data.models.Variant

/**
 * Created by pranit on 13/1/18.
 */
@Dao interface VariantDao {

    /**
     * Get all variants from local storage
     *
     * @return List of variant
     */
    @Query("SELECT * FROM $TABLE_VARIANT")
    fun getVariants() :List<Variant>

    /**
     * Inserts variant data into local storage
     *
     * @param variant data
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVariant(variant:  Variant)

    /**
     * Delete all variants
     */
    @Query("DELETE FROM $TABLE_VARIANT")
    fun deleteVariants()
}