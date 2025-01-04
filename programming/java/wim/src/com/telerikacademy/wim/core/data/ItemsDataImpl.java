package com.telerikacademy.wim.core.data;

import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDataImpl {

    private String filename = "src/datafiles/items.txt";
    private File dataFile = new File(filename);


    public void saveItemsToDatabase(List<WorkingItems> staffUpdates) throws IOException {

        OutputStream os = new FileOutputStream(dataFile);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(staffUpdates);


    }

    public void loadItemsFromDatabase(List<WorkingItems> itemsData) throws IOException, ClassNotFoundException {
        List<WorkingItems> data;
        InputStream is = new FileInputStream(dataFile);
        ObjectInputStream ois = new ObjectInputStream(is);

        data = (List<WorkingItems>) ois.readObject();
        itemsData.addAll(data);
    }

}
