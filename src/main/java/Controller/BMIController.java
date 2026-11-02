package controller;

import java.text.DecimalFormat;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import model.BMI;
import model.BMILakiLaki;
import model.BMIPerempuan;

public class BMIController {

    @FXML
    private TextField beratField;

    @FXML
    private TextField tinggiField;

    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private Label hasilLabel;

    private final DecimalFormat formatBMI =
            new DecimalFormat("0.00");

    @FXML
    private void initialize() {

        genderBox.getItems().addAll(
                "Laki-laki",
                "Perempuan"
        );

        genderBox.setValue("Laki-laki");
    }

    // Method untuk menghitung BMI
    @FXML
    private void hitung() {

        try {

            // Mengambil input pengguna
            double berat = Double.parseDouble(
                    beratField.getText().trim().replace(",", ".")
            );

            double tinggi = Double.parseDouble(
                    tinggiField.getText().trim().replace(",", ".")
            );

            // Memeriksa gender
            String gender = genderBox.getValue();

            if (gender == null) {
                tampilkanError("Silakan pilih gender.");
                return;
            }

            // Membuat objek berdasarkan gender
            BMI bmi;

            if ("Laki-laki".equals(gender)) {

                bmi = new BMILakiLaki(berat, tinggi);

            } else {

                bmi = new BMIPerempuan(berat, tinggi);

            }

            // Menghitung BMI
            double nilaiBMI = bmi.hitungBMI();

            // Mengambil kategori
            String kategori = bmi.getKategori();

            // Mengambil saran
            String saran = bmi.getSaran();

            // Menampilkan hasil
            hasilLabel.setStyle(
                    "-fx-text-fill: #166534;"
            );

            hasilLabel.setText(
                    "HASIL PERHITUNGAN BMI\n\n"
                    + "Gender : " + gender + "\n"
                    + "Berat Badan : " + berat + " kg\n"
                    + "Tinggi Badan : " + tinggi + " cm\n"
                    + "Nilai BMI : " + formatBMI.format(nilaiBMI)
                    + "\nKategori : " + kategori
                    + "\n\nSaran:\n" + saran
            );

        } catch (NumberFormatException e) {

            tampilkanError(
                    "Berat dan tinggi badan harus berupa angka yang valid."
            );

        } catch (IllegalArgumentException e) {

            tampilkanError(e.getMessage());

        }
    }

    // Method menampilkan pesan error
    private void tampilkanError(String pesan) {

        hasilLabel.setStyle(
                "-fx-text-fill: #b91c1c;"
        );

        hasilLabel.setText(pesan);
    }

    // Method reset
    @FXML
    private void reset() {

        beratField.clear();
        tinggiField.clear();

        genderBox.setValue("Laki-laki");

        hasilLabel.setStyle(
                "-fx-text-fill: #64748b;"
        );

        hasilLabel.setText(
                "Hasil perhitungan akan tampil di sini."
        );
    }
}