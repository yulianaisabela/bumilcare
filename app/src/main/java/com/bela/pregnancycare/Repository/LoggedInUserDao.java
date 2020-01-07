package com.bela.pregnancycare.Repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.bela.pregnancycare.Model.LoggedinUser;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;
/*
 * DAO class to call database LoggedInUserDb
 * */
@Dao
public interface LoggedInUserDao {

    @Query("SELECT * FROM LoggedinUser")
    List<LoggedinUser> getAll();

    @Query("SELECT * FROM LoggedinUser WHERE username LIKE :username LIMIT 1")
    LoggedinUser findByUsername(String username);

    @Query("SELECT * FROM LoggedinUser WHERE userid = :userid LIMIT 1")
    LoggedinUser findByID(int userid);

    @Insert
    void insertAll(LoggedinUser... loggedinUsers);

    @Insert
    long insert(LoggedinUser loggedinUser);

    @Delete
    void delete(LoggedinUser loggedinUser);

    @Update(onConflict = REPLACE)
    public void updateUsers(LoggedinUser... loggedinUsers);

    @Query("DELETE FROM LoggedinUser")
    void deleteAll();
}
