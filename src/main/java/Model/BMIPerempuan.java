package model;

public class BMIPerempuan extends BMI {

    public BMIPerempuan(double beratBadan, double tinggiBadan) {
        super(beratBadan, tinggiBadan);
    }

    @Override
    public String getSaran() {

        double bmi = hitungBMI();

        if (bmi < 18.5) {
            return "Berat badan Anda tergolong kurang. "
                    + "Perhatikan kecukupan energi, protein, "
                    + "zat besi, dan nutrisi lainnya.";
        } else if (bmi < 25) {
            return "Berat badan Anda normal. "
                    + "Pertahankan pola makan seimbang "
                    + "dan aktivitas fisik secara teratur.";
        } else if (bmi < 30) {
            return "Berat badan Anda berlebih. "
                    + "Mulailah memperhatikan pola makan "
                    + "dan melakukan aktivitas fisik.";
        } else {
            return "BMI Anda termasuk kategori obesitas. "
                    + "Pertimbangkan konsultasi dengan "
                    + "tenaga kesehatan untuk memperoleh "
                    + "pendampingan yang sesuai.";
        }
    }
}