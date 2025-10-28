public class MethodOverridingPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Method Overriding
         *
         * Instruksi: Lengkapi semua latihan untuk menguasai method overriding,
         * covariant return types, dan best practices.
         */

        // ===== BASIC METHOD OVERRIDING =====
        System.out.println("=== BASIC METHOD OVERRIDING ===");

        // Latihan 1: Override method toString()
        // - Buat object Mahasiswa dengan parameter:
        //   nim: "2024001", nama: "Budi", jurusan: "Informatika", ipk: 3.75
        // - Print object menggunakan toString()
        System.out.println("LATIHAN 1");
        Mahasiswa m1 = new Mahasiswa("2024001", "Budi", "Informatika", 3.75);
        System.out.println(m1.toString());

        // Ekspektasi Output:
        // Mahasiswa{nim='2024001', nama='Budi', jurusan='Informatika', ipk=3.75}

        // Latihan 2: Override method equals()
        // - Buat dua object Mahasiswa dengan NIM yang sama
        // - Compare menggunakan equals()
        // - Compare menggunakan == (reference equality)
        System.out.println("LATIHAN 2");
        Mahasiswa m2 = new Mahasiswa("2024001", "Budi Santoso", "Sistem Informasi", 3.8); // NIM sama
        Mahasiswa m3 = new Mahasiswa("2024002", "Andi", "Informatika", 3.5); // NIM beda

        System.out.println("m1.equals(m2): " + m1.equals(m2) + " (karena NIM sama)");
        System.out.println("m1 == m2: " + (m1 == m2) + " (referensi berbeda)");
        // Ekspektasi Output:
        // m1.equals(m2): true (karena NIM sama)
        // m1 == m2: false (referensi berbeda)

        // ===== OVERRIDING WITH SUPER =====
        System.out.println("\n=== OVERRIDING WITH SUPER ===");

        // Latihan 3: Override dengan memanggil super
        // - Buat object Dosen dengan parameter:
        //   nip: "198901001", nama: "Dr. Sarah", jurusan: "Informatika",
        //   mataKuliah: "PBO", pengalamanMengajar: 10
        // - Panggil method displayInfo()
        System.out.println("LATIHAN 3");
        Dosen d1 = new Dosen("198901001", "Dr. Sarah", "Informatika", "PBO", 10);
        d1.displayInfo();


        // Ekspektasi Output:
        // === Info Pegawai ===
        // NIP: 198901001
        // Nama: Dr. Sarah
        // Jurusan: Informatika
        // Mata Kuliah: PBO
        // Pengalaman: 10 tahun

        // Latihan 4: Chain of overriding
        // - Buat object DosenProfessor extends Dosen
        // - Override displayInfo() untuk menambah info gelar profesor
        // - Test chain dari Pegawai -> Dosen -> DosenProfessor
        System.out.println("LATIHAN 4");
        DosenProfessor dp1 = new DosenProfessor("197502021", "Prof. Agung", "Informatika", "AI", 25, "Ph.D., M.Sc.", 50);
        dp1.displayInfo();

        // Ekspektasi Output:
        // Pegawai constructor called
        // Dosen constructor called
        // DosenProfessor constructor called
        // [info lengkap dengan gelar profesor]

        // ===== COVARIANT RETURN TYPES =====
        System.out.println("\n=== COVARIANT RETURN TYPES ===");

        // Latihan 5: Return type yang lebih spesifik
        // - Override method clone() untuk return type yang lebih spesifik
        // - Parent return type: Pegawai
        // - Child return type: Dosen (covariant)
        System.out.println("LATIHAN 5");
        Dosen d2 = new Dosen("199010101", "Ani", "Kimia", "Organik", 5);
        Dosen d2Clone = d2.clone(); // Covariant return type: Dosen

        System.out.println("Clone berhasil dengan type yang lebih spesifik");
        System.out.println("original != clone: " + (d2 != d2Clone) + " (referensi berbeda)");
        System.out.println("original.equals(clone): " + d2.nip.equals(d2Clone.nip) + " (konten sama)");

        // Ekspektasi Output:
        // Clone berhasil dengan type yang lebih spesifik
        // original != clone (referensi berbeda)
        // original.equals(clone) (konten sama)

        // ===== OVERRIDING RULES =====
        System.out.println("\n=== OVERRIDING RULES ===");

        // Latihan 6: Access modifier rules
        // - Override method dengan access yang sama atau lebih luas
        // - Test: protected -> public (VALID)
        // - Test: public -> protected (INVALID - compile error)
        System.out.println("LATIHAN 6");
        Dosen d3 = new Dosen("000", "Tes", "Tes", "Tes", 1);
        System.out.print("Widening access modifier: ");
        d3.methodProtected(); // Panggil method yang sudah di-override menjadi public

        System.out.println("Narrowing access modifier: COMPILE ERROR");

        // Ekspektasi Output:
        // Widening access modifier: ALLOWED
        // Narrowing access modifier: COMPILE ERROR

        // Latihan 7: Return type rules
        // - Override dengan same return type
        // - Override dengan covariant return type
        // - Override dengan unrelated return type (ERROR)
        System.out.println("LATIHAN 7");
        System.out.println("Same return type: VALID");
        System.out.println("Covariant return type: VALID");
        System.out.println("Unrelated return type: COMPILE ERROR");

        // Ekspektasi Output:
        // Same return type: VALID
        // Covariant return type: VALID
        // Unrelated return type: COMPILE ERROR

        // Latihan 8: Final method
        // - Try to override final method -> COMPILE ERROR
        // - Final method tidak bisa di-override
        System.out.println("LATIHAN 8");
        System.out.println("Cannot override final method: COMPILE ERROR");
        // Ekspektasi Output:
        // Cannot override final method: COMPILE ERROR
    }
}
