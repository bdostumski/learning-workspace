package com.telerikacademy.wim.core.data;

import com.telerikacademy.wim.models.contracts.Team;

import java.io.*;
import java.util.List;

public class TeamsDataImpl {

   private String filename = "src/datafiles/teams.txt";
   private File dataFile = new File(filename);

    public void saveItemsToDatabase(List<Team> teamsUpdate) throws IOException {
        OutputStream os = new FileOutputStream(dataFile);
        ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(teamsUpdate);

    }

    public void loadItemsFromDatabase(List<Team> teamsData) throws IOException, ClassNotFoundException {
        List<Team> data;

        InputStream is = new FileInputStream(dataFile);
        ObjectInputStream ois = new ObjectInputStream(is);

            data = (List<Team>) ois.readObject();
            teamsData.addAll(data);

    }
}
