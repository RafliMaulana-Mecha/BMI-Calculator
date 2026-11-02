package model;

public abstract class BMI {

    private final double beratBadan;
    private final double tinggiBadan;

    public BMI(double beratBadan, double tinggiBadan) {

        if (!Double.isFinite(beratBadan) || beratBadan <= 0) {
            throw new IllegalArgumentException(
                "Berat badan harus lebih dari 0."
            );
        }

        if (!Double.isFinite(tinggiBadan) || tinggiBadan <= 0) {
            throw new IllegalArgumentException(
                "Tinggi badan harus lebih dari 0."
            );
        }

        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }

    // Method menghitung BMI
    public double hitungBMI() {
        double tinggiMeter = tinggiBadan / 100;
        return beratBadan / (tinggiMeter * tinggiMeter);
    }

    // Method menentukan kategori BMI
    public String getKategori() {

        double bmi = hitungBMI();

        if (bmi < 18.5) {
            return "Berat Badan Kurang";
        } else if (bmi < 25) {
            return "Berat Badan Normal";
        } else if (bmi < 30) {
            return "Berat Badan Berlebih";
        } else {
            return "Obesitas";
        }
    }

    // Method abstract untuk saran berdasarkan gender
    public abstract String getSaran();
}