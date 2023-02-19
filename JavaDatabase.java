import java.sql.*;
import java.util.ArrayList;
import java.util.List;
package JavaDatabase;

public class JavaDatabase {
    public static void main(String[] args) {
        // Mengatur parameter koneksi
        String url = "jdbc:mysql://localhost:3306/nama_database";
        String user = "nama_pengguna";
        String password = "kata_sandi";

        try {
            // Membuat koneksi
            Connection conn = DriverManager.getConnection(url, user, password);

            // Membuat statement untuk mengeksekusi perintah SQL
            Statement stmt = conn.createStatement();

            // Mengeksekusi perintah SQL untuk mengambil data dari tabel
            ResultSet rs = stmt.executeQuery("SELECT * FROM nama_tabel");

            // Memproses hasil query dan menyimpannya ke dalam List
            List<Data> dataList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                int umur = rs.getInt("umur");
                Data data = new Data(id, nama, umur, alamat);
                dataList.add(data);
            }

            // Menutup koneksi dan statement
            rs.close();
            stmt.close();
            conn.close();

            // Menggunakan data yang telah diambil dari database
            for (Data data : dataList) {
                System.out.println(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Kelas untuk merepresentasikan data dari tabel
class Data {
    private int id;
    private String nama;
    private String alamat;
    private int umur;

    public Data(int id, String nama, String alamat, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Data [id=" + id + ", nama=" + nama + ", umur=" + umur + ", tempat tinggal=" + alamat"]";
    }
}
