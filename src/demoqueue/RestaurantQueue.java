    package demoqueue;
    import java.util.Queue;
    import java.util.Scanner;
    import java.util.concurrent.ArrayBlockingQueue; // Import ArrayBlockingQueue

    public class RestaurantQueue {
        private Queue<Customer> queue;
        private Scanner scanner;
        private int nomorPesanan; // Variabel untuk menyimpan nomor pesanan berikutnya
        private final int kapasitasMax = 3; // Batas kapasitas queue

        public RestaurantQueue() {
            // Inisialisasi queue dengan ArrayBlockingQueue dengan kapasitas 3
            queue = new ArrayBlockingQueue<>(kapasitasMax);
            scanner = new Scanner(System.in);
            nomorPesanan = 1; // Inisialisasi nomor pesanan pertama
        }

        // Menambahkan pelanggan ke dalam antrian menggunakan add
        public void tambahWithAdd() {
            if (queue.size() >= kapasitasMax) {
                throw new IllegalStateException("Antrian penuh!"); // Lemparkan exception jika penuh
            } else {
                System.out.print("Masukkan nama pelanggan: ");
                String name = scanner.nextLine();
                Customer customer = new Customer(name, nomorPesanan);
                queue.add(customer); // Menggunakan add()
                System.out.println("\n>> Menambah (add): " + name + " telah ditambahkan ke antrian dengan nomor pesanan " + nomorPesanan + ". >>");
                nomorPesanan++;
            }
        }
        

        // Menambahkan pelanggan ke dalam antrian menggunakan offer
        public void tambahWithOffer() {
            System.out.print("Masukkan nama pelanggan: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(name, nomorPesanan);
            boolean success = queue.offer(customer); // Menggunakan offer()
            if (success) {
                System.out.println("\n>> Menambah (offer): " + name + " telah ditambahkan ke antrian dengan nomor pesanan " + nomorPesanan + ". >>");
                nomorPesanan++;
            } else {
                System.out.println("\n" + success);
                System.out.println(">> Antrian penuh! Tidak dapat menambahkan pelanggan menggunakan offer. >>");
            }
        }

        // Melayani pelanggan teratas menggunakan remove
        public void hapusWithRemove() {
            if (!queue.isEmpty()) {
                Customer hapusCustomer = queue.remove(); // Menggunakan remove()
                System.out.println(">> Menghapus (remove): Melayani " + hapusCustomer.getName() + " dengan nomor pesanan " + hapusCustomer.getOrderNumber());
            } else {
                throw new IllegalStateException("Antrian kosong!"); // Lemparkan exception jika kosong
            }
        }

        // Melayani pelanggan teratas menggunakan poll
        public void hapusWithPoll() {
            Customer hapusCustomer = queue.poll(); // Menggunakan poll()
            if (hapusCustomer != null) {
                System.out.println(">> Menghapus (poll): Melayani " + hapusCustomer.getName() + " dengan nomor pesanan " + hapusCustomer.getOrderNumber());
            } else {
                System.out.println("\n" + hapusCustomer);
                System.out.println(">> Antrian kosong, tidak ada pelanggan yang dapat dilayani.");
            }
        }

        // Menampilkan pelanggan teratas menggunakan element
        public void queueWithElement() {
            try {
                Customer nextCustomer = queue.element(); // Menggunakan element()
                System.out.println("\n>> Element -> Pelanggan pertama: " + nextCustomer);
            } catch (Exception e) {
                throw e; // Lemparkan exception jika kosong
            }
        }

        // Menampilkan pelanggan pertama tanpa menghapusnya menggunakan peek
        public void queueWithPeek() {
            Customer nextCustomer = queue.peek(); // Menggunakan peek()
            if (nextCustomer != null) {
                System.out.println("\n>> Peek -> Pelanggan pertama: " + nextCustomer);
            } else {
                System.out.println("\n" + nextCustomer);
                System.out.println(">> Antrian kosong, tidak ada pelanggan pertama.");
            }
        }

        // Menampilkan semua pelanggan dalam antrian
        public void allCustomer() {
            if (queue.isEmpty()) {
                System.out.println("Tidak ada pelanggan dalam antrian.");
            } else {
                System.out.println("Daftar pelanggan dalam antrian:\n");
                for (Customer customer : queue) {
                    System.out.println(customer);
                }
            }
        }

        public void display() {
            int pilihan;
            do {
                System.out.println("\nMenu Queue Program:");
                System.out.println("1. Tambah Elemen (add)");
                System.out.println("2. Tambah Elemen (offer)");
                System.out.println("3. Hapus Elemen (remove)");
                System.out.println("4. Hapus Elemen (poll)");
                System.out.println("5. Lihat Elemen Depan (element)");
                System.out.println("6. Lihat Elemen Depan (peek)");
                System.out.println("7. Lihat Semua Elemen");
                System.out.println("8. Keluar");
                System.out.print("\nPilihan Anda: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline
        
                switch (pilihan) {
                    case 1:
                        tambahWithAdd();
                        break;
                    case 2:
                        tambahWithOffer();
                        break;
                    case 3:
                        hapusWithRemove();
                        break;
                    case 4:
                        hapusWithPoll(); // Tambahkan opsi untuk poll
                        break;
                    case 5:
                        queueWithElement();
                        break;
                    case 6:
                        queueWithPeek();
                        break;
                    case 7:
                        allCustomer();
                        break;
                    case 8:
                        System.out.println("Terima kasih telah menggunakan program ini!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } while (pilihan != 8);
        }
    }
