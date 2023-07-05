package com.sss.talakona.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Talakona.class},version = 1)
public abstract class TalakonaDatabase extends RoomDatabase {
    public abstract TalakonaDao getDao();
    public static TalakonaDatabase INSTANCE;
    public static TalakonaDatabase getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,TalakonaDatabase.class,"TALAKONADATABASE").
                    allowMainThreadQueries().
                    fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

}
