package com.example.hp.hellowwordl.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import com.example.hp.hellowwordl.model.Address;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "medicionDB.sqlite";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 3;

    // the DAO object we use to access the SimpleData table
    private Dao<Address, Integer> addressDao = null;
    //private Dao<Meter, Long> meterDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Address.class);
            //TableUtils.createTable(connectionSource, Meter.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            List<String> allSql = new ArrayList<String>();
            switch(oldVersion)
            {
                case 1:
                    //allSql.add("alter table AdData add column `new_col` VARCHAR");
                    //allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql) {
                database.execSQL(sql);
            }
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }
    }
//Address functions helpers
    public Dao<Address, Integer> getAddressDao() {
        if (null == addressDao) {
            try {
                addressDao = getDao(Address.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return addressDao;
    }

}
