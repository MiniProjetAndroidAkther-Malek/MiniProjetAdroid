package com.example.miniprojectakthemmalek.view.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.miniprojectakthemmalek.model.api.entityInterface.IUser;
import com.example.miniprojectakthemmalek.model.entities.Converter;
import com.example.miniprojectakthemmalek.model.entities.User;
import com.example.miniprojectakthemmalek.view.dao.IUserDao;


@Database(entities = {User.class},version = 1,exportSchema = false)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {

        private static AppDatabase instance;

        public abstract IUserDao userDao();

        public static AppDatabase getInstance(Context context)
        {

            if(instance==null)
            {

                instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"userDB6").allowMainThreadQueries().build();

            }

            return instance;
        }



}
