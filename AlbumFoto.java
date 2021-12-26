package ditaindriawati;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dita Indriawati
 */
public class AlbumFoto {
    
  private int maxAmount = 0;
  private int currentIndex = 0;
  private String[] items = new String[1];

  void setMaxItemAmount(int maxAmount) {
    this.maxAmount = maxAmount;
    this.items = new String[this.maxAmount];
  }

  void addItem(String item) throws ArrayIndexOutOfBoundsException {
    this.items[this.currentIndex] = item;
    this.currentIndex++;
  }

  String[] getItems() {
    return this.items;
  }
  
  public static void main(String[] args) {
    AlbumFoto albumFoto = new AlbumFoto();
    Scanner jumlahFotoHandler = new Scanner(System.in);
    Scanner PhotoInput = new Scanner(System.in);
    Scanner statusInput = new Scanner(System.in);
    boolean addingPhoto = true;

    System.out.print("Dapat memuat berapa Foto ? : ");
    int jumlahMaksimalFoto = jumlahFotoHandler.nextInt();
    albumFoto.setMaxItemAmount(jumlahMaksimalFoto);
    System.out.println(jumlahMaksimalFoto);

    try {
      while(addingPhoto) {
        System.out.println();
        System.out.println("=======================");
        System.out.println("[1] Tambahkan Foto Anda ");
        System.out.println("[2] Keluar ");
        System.out.println("=======================");
        System.out.println();

        System.out.print("Pilih : ");
        int decision = statusInput.nextInt();

        if (decision == 1) {
          System.out.print("Masukan Foto anda      : ");
          String foto = PhotoInput.nextLine();
          albumFoto.addItem(foto);

          System.out.println("FOTO ANDA TELAH DITAMBAHKAN");
        }

        if (decision == 2) {
          addingPhoto = false;
        }
      }

    } catch (InputMismatchException err) {
      System.out.println("Jangan masukan apapun selain Gambar dan Video");
    } catch (ArrayIndexOutOfBoundsException err) {
      System.out.println("Memori Anda Sudah Penuh");
    } finally {
      System.out.println("Isi Album Anda : " + Arrays.deepToString(albumFoto.getItems()));
    }
  }
}