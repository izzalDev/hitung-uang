package app;

public class Uang {
    private Long nominal;
    private static Integer[] pecahan = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100};

    public Uang(Long nominal) {
        this.nominal = nominal;
    }

    public Uang(String nominal) {
        this.nominal = Long.parseLong(nominal);
    }

    public Long getNominal() {
        return nominal;
    }

    public Long setNominal(Long nominal) {
        return this.nominal = nominal;
    }

    public String toString() {
        return String.valueOf(nominal);
    }

    public String getPecahan() {
        StringBuilder hasil = new StringBuilder();
        for (Integer uang : pecahan) {
            Long jumlah = nominal / uang;
            if (jumlah > 0) {
                hasil.append(jumlah).append(" x ").append(uang).append("\n");
                nominal %= uang;
            }
        }
        if (nominal > 0) {
            hasil.append("Sisa: ").append(nominal).append("\n");
        }
        return hasil.toString();
    }
}
