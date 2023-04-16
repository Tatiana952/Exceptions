package sem3_home.Writer.Format;

import java.io.*;
import java.util.List;

public class SaveTXT extends TextFormat {
    /**
     * Function for saving data in TXT format. File will be saved in folder 'files' in working folder.
     * File name = value in the first cell of list
     * @param data List with data for save
     */
    @Override
    public void save(List<String> data) {
        String fio = data.get(0) + " " + data.get(1) + " " + data.get(2);
        String birth = data.get(3);
        String phone = data.get(4);
        String gender = data.get(5).toLowerCase();
        String path = "files/" + data.get(0) + ".txt";

        String full = fio + " " + birth + " " + phone + " " + gender;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.append("\n");
            writer.append(full);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
