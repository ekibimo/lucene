/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author TOSHIBA
 */
public class index {

    public Directory doIndexing() {
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);

        // Membuat index baru dalam bentuk RAMDirectory
        Directory index = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_42, analyzer);
        try {
            try (IndexWriter w = new IndexWriter(index, config)) {
                addDoc(w, "Electronic", "Sony 32", "-44%", "RP 4.900.000");
                addDoc(w, "Electronic", "LG 32", "-20%", "RP 3.450.000");
                addDoc(w, "Electronic", "Changhong LED TV 24", "-38%", "RP 2.499.000");
                addDoc(w, "Electronic", " LG 32LB530 LED TV - 32", "-20%", "RP 3.450.000");
                addDoc(w, "Electronic", "Sharp 32", "-17%", "Harga: RP 3.129.000");
                addDoc(w, "Handphone", "Sony Xperia Z3 - 16 GB", "-6%", "RP 8.499.000");
                addDoc(w, "Handphone", "LG G2 Mini - 8 GB", "-24%", "RP 3.299.000");
                addDoc(w, "Handphone", "Nokia X Dual Sim - 4 GB", "-28%", "RP 1.599.000");
                addDoc(w, "Handphone", "Samsung Galaxy Mega 5.8 I9152 - 8 GB", "-40%", "RP 5.499.000");
                addDoc(w, "Handphone", "SPC Mobile S12 Razor - Putih ", "-14%", "RP 699.000");
                addDoc(w, "Laptop", "HP Pavilion 10 - F001AU ( Ai ) AMD A4-1200", "-23%", "RP 3.499.000");
                addDoc(w, "Laptop", "Lenovo Thinkpad X1-Carbon (i7) Ultrabook Windows 8 - 14", "-28%", "RP 23.000.000");
                addDoc(w, "Laptop", "TOSHIBA C840-1029", "-", "RP 4.999.000");
                addDoc(w, "Camera", "Samsung WB-35F Smart Camera", "-44%", "RP 2.499.000");
                addDoc(w, "Camera", "Sony Digital Camera DSC-H300", "-21%", "RP 2.950.000");
                addDoc(w, "Watches", "Casio Jam Tangan AE-1000W-1BVDF", "-38%", "RP 445.000");
                addDoc(w, "Watches", "Maxima 26844LMGI Men watch", "-50%", "RP 994.500");
                addDoc(w, "Watches", "Jacques Lemans UEFA Chrono", "-60%", "RP 4.728.000");
            }
        } catch (IOException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }

        return index;
    }

    //method yang digunakan untuk menambahkan dokumen ke index
    private static void addDoc(IndexWriter w, String category, String nama, String diskon, String harga) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("category", category, Field.Store.YES));
        doc.add(new StringField("namaproduk", nama, Field.Store.YES));
        doc.add(new StringField("diskon", diskon, Field.Store.YES));
        doc.add(new StringField("harga", harga, Field.Store.YES));
        w.addDocument(doc);
    }
}
