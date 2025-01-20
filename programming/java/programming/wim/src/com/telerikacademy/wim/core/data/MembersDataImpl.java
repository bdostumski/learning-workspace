package com.telerikacademy.wim.core.data;

import com.telerikacademy.wim.models.contracts.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MembersDataImpl {

   private String filename = "src/datafiles/members.txt";
   private File dataFile = new File(filename);


    public void saveItemsToDatabase(List<Member> membersUpdate) throws IOException {
        OutputStream os = new FileOutputStream(dataFile);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(membersUpdate);

    }

    public void loadItemsFromDatabase(List<Member> membersData) throws IOException, ClassNotFoundException {
        List<Member> data;

        InputStream is = new FileInputStream(dataFile);
        ObjectInputStream ois = new ObjectInputStream(is);

            data = (List<Member>) ois.readObject();
            membersData.addAll(data);

    }

}
