package model;

public class BMILakiLaki extends BMI {

    public BMILakiLaki(double beratBadan, double tinggiBadan) {
        super(beratBadan, tinggiBadan);
    }

    @Override
    public String getSaran() {

        double bmi = hitungBMI();

        if (bmi < 18.5) {
            return "Berat badan Anda tergolong kurang. "
                    + "Perhatikan asupan kalori, protein, "
                    + "dan nutrisi yang seimbang.";
        } else if (bmi < 25) {
            return "Berat badan Anda normal. "
                    + "Pertahankan pola makan sehat "
                    + "dan olahraga secara teratur.";
        } else if (bmi < 30) {
            return "Berat badan Anda berlebih. "
                    + "Perhatikan pola makan dan "
                    + "tingkatkan aktivitas fisik.";
        } else {
            return "BMI Anda termasuk kategori obesitas. "
                    + "Pertimbangkan konsultasi dengan "
                    + "tenaga kesehatan untuk mendapatkan "
                    + "saran yang tepat.";
        }
    }
}