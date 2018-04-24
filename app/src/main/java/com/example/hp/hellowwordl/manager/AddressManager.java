package com.example.hp.hellowwordl.manager;

import android.content.Context;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.hp.hellowwordl.helper.DatabaseHelper;
import com.example.hp.hellowwordl.model.Address;

public class AddressManager {
    static private AddressManager instance;
    //aqui es el pedo
    public static void init(Context ctx) {
        if (null==instance) {
            instance = new AddressManager(ctx);
        }
    }
    static public AddressManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private AddressManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<Address> getAllMeterLists() {
        List<Address> addressList = new ArrayList<>();
        try {
            addressList = getHelper().getAddressDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    public void saveAddress(final Address address) {
        try {
            getHelper().getAddressDao().create(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAddress(final Address address) {
        try {
            getHelper().getAddressDao().update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Address getAddress(){
        Address address=null;
        try{
           address=getHelper().getAddressDao().queryBuilder().queryForFirst();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

}
