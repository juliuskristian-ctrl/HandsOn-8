public class Dosen extends Pegawai {
    // Properties tambahan
    private String mataKuliah;
    private int pengalamanMengajar;

    // Constructor
    public Dosen(String nip, String nama, String jurusan,
                 String mataKuliah, int pengalamanMengajar) {
        // TODO: Implementasi dengan super
        super(nip, nama, jurusan);
        this.mataKuliah = mataKuliah;
        this.pengalamanMengajar = pengalamanMengajar;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        // TODO: Override dengan info dosen
        super.displayInfo();
        System.out.println("Mata Kuliah: " + mataKuliah);
        System.out.println("Pengalaman: " + pengalamanMengajar + " tahun");
    }

    // Override clone dengan covariant return type
    @Override
    public Dosen clone() {
        // TODO: Return new Dosen
        return new Dosen(this.nip, this.nama, this.jurusan, this.mataKuliah, this.pengalamanMengajar);
    }

    // Override dengan widening access
    @Override
    public void methodProtected() {
        // TODO: Override dari protected ke public
        System.out.println("Public method in Dosen (widened access)");
    }
}
