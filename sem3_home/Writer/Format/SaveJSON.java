package sem3_home.Writer.Format;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class SaveJSON extends TextFormat{
    /**
     * Function for saving data in JSON format. File will be saved in folder 'files' in working folder.
     * File name = value in the first cell of list
     * @param data List with data for save
     */
    @Override
    public void save(List<String> data) {
        String fio = data.get(0) + " " + data.get(1) + " " + data.get(2);
        String birth = data.get(3);
        String phone = data.get(4);
        String gender = data.get(5).toLowerCase();
        String path = "files/" + data.get(0) + ".json";

        JSONObject jsonDetails = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        JSONArray personList = null;

        jsonDetails.put("FIO", fio);
        jsonDetails.put("Birthday", birth);
        jsonDetails.put("Phone", phone);
        jsonDetails.put("Gender", gender);
        jsonObject.put("Person", jsonDetails);

        if (new File(path).isFile()) {
            try (FileReader reader = new FileReader(path)) {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(reader);
                personList = (JSONArray) obj;
                personList.add(jsonObject);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            personList = new JSONArray();
            personList.add(jsonObject);
        }

        try (FileWriter file = new FileWriter(path)) {
            file.write(personList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
