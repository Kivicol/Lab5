package src.command.Utility;


import java.io.*;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import src.command.Receiver;
import src.data.Route;

public class FileManager {

    static String filePath = System.getenv("FILE_PATH") + "\\data.json";

    public void saveToJson(LinkedList<Route> table) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new TimeAdapter())
                .setPrettyPrinting().create().newBuilder();
        Gson gson = gsonBuilder.create();
        String data = gson.toJson(table);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        }catch (IOException e){
            System.out.println("Smth went wrong, data was not saved");
        }
    }

    public LinkedList<Route> loadFromJson() throws JsonSyntaxException, JsonIOException{
        LinkedList<Route> table = new LinkedList<>();
        ArrayList<Route> buffer;
        IdGenerate idGenerate = new IdGenerate();
        try{
            File file = new File(filePath);
            Scanner scan = new Scanner(file);
            Type itemsArrayType = new TypeToken<ArrayList<Route>>() {}.getType();
            String data = "";
            while (scan.hasNextLine()){
                data = data.concat(scan.nextLine());
            }
            buffer = new Gson().fromJson(data, itemsArrayType);
            for (Route route : buffer){
                table.add(route);
                idGenerate.add(IdGenerate.generateId());
            }
            return table;
        }catch (JsonSyntaxException e){
            System.out.println("Something wrong with the file or it is empty.");
            return table;
        }catch (JsonIOException | FileNotFoundException e){
            System.out.println("File not found");
            return table;
        }
    }
}