package id.ac.uny.riset.darling.data;

import java.util.ArrayList;
import java.util.List;

import id.ac.uny.riset.darling.data.model.PickerModel;

public class StaticData {
    public static List<PickerModel> dataHubungan(){
        List<PickerModel> dataAgama = new ArrayList<>();

        PickerModel data = new PickerModel("1", "Berpacaran");
        dataAgama.add(data);

        data = new PickerModel("2", "Tidak Berpacaran");
        dataAgama.add(data);

        return dataAgama;
    }

    public static List<PickerModel> dataJenisKelamin(){
        List<PickerModel> dataAgama = new ArrayList<>();

        PickerModel data = new PickerModel("1", "Laki - Laki");
        dataAgama.add(data);

        data = new PickerModel("2", "Perempuan");
        dataAgama.add(data);

        return dataAgama;
    }
}
