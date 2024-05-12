package parniyan.mahmoudroid.compose.base.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */


/**
 * Base dao that provides basic operations
 * */
interface BaseDao<T> {

    /**
     * inserts one item asynchronously
     *
     * @param item item to insert
     * @return id of inserted item
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    /**
     * inserts one item synchronously
     *
     * @param item item to insert
     * @return id of inserted item
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSync(item: T): Long

    /**
     * inserts list of items asynchronously
     *
     * @param items item list to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<T>)

    /**
     * inserts list of items synchronously
     *
     * @param items item list to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSync(items: List<T>)

    /**
     * updates one item asynchronously
     *
     * @param item item to update
     * @return updated rows
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: T): Int

    /**
     * updates one item synchronously
     *
     * @param item item to update
     * @return updated rows
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSync(item: T): Int

}
