package sem3_home;

import sem3_home.Exceptions.*;
import sem3_home.Writer.Format.SaveJSON;
import sem3_home.Writer.Format.SaveTXT;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UI ui = new UI();
        byte mode = 0;
        while (ui.isFollow()){
            ui.conditions(1);
            try {
                mode = ui.chooseFormat();
            } catch (ModeException e) {
                System.err.println(e.getMessage());
            } catch (EmptyDataException e) {
                System.err.println(e.getMessage());
            }
        }

        ui.changeFollow();

        DataCheker dataCheker = new DataCheker();
        List<String> data = null;

        while (ui.isFollow()){
            ui.conditions(2);
            try{
                data = ui.readData();
                if (data.get(0).equals("X")) break;
                dataCheker.checkCountData(data);
                dataCheker.checkFields(data);
            }catch (EmptyDataException e){
                System.err.println(e.getMessage());
            }catch (LackOfDataException | ExcessOfDataException e) {
                System.err.printf("%s Amount of entered data fields: %d.\n", e.getMessage(), e.getAmount());
            }
            if (mode == 1){
                SaveJSON saveJSON = new SaveJSON();
                saveJSON.save(data);
            }else {
                SaveTXT saveTXT = new SaveTXT();
                saveTXT.save(data);
            }
        }
    }
}
