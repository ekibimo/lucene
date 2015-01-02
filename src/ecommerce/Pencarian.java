/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.io.IOException;
import java.util.Scanner;
import org.apache.lucene.queryparser.classic.ParseException;

/**
 *
 * @author TOSHIBA
 */
public class Pencarian {

    public static void main(String[] args) throws IOException, ParseException {

        String produk;
        System.out.print("Apa Barang Yang Anda Butuhkan Saat Ini?: ");
        Scanner in = new Scanner(System.in);
        produk = in.nextLine();
        Search search = new Search();
        search.doSearching(produk);

    }
}
