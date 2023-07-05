package com.sss.talakona.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TalakonaDao {
    @Insert
    void insert(Talakona talakona);

    @Query("select * from Talakona")
    List<Talakona> getTalakona();

}
