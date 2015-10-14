package EJ7AD;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ** @author oracle ***
 */
public class Products {

    private final String ruta = "productos.txt";
    private final File file = new File(ruta);
    private DataOutputStream dos;
    private DataInputStream dis;

    public static void main(String[] args) throws IOException {

        Products2 po1 = new Products2("cod1", "parafusos", 3);
        Products2 po2 = new Products2("cod2", "arandelas", 4);
        Products2 po3 = new Products2();

        Products ps = new Products();
        ps.Escribir(po1);
        ps.Escribir(po2);
        ps.Leer(po3);
    }

    public void Escribir(Products2 pro) throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            dos = new DataOutputStream(new FileOutputStream(file, true)); 														// True
            dos.writeUTF(pro.getCodigo());
            dos.writeUTF(pro.getDescripcion());
            dos.writeByte(pro.getPrezo());

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            dos.close();
        }
    }

    public void Leer(Products2 obj) throws IOException {
        try {
            dis = new DataInputStream(new FileInputStream(file));
            byte i = 1;
            while (dis.available() > 0) {
                obj.setCodigo(dis.readUTF());
                obj.setDescripcion(dis.readUTF());
                obj.setPrezo(dis.readByte());
                System.out.println("Valores del objeto po" + i + ":" + "\n Código: " + obj.getCodigo() + "\n Descripción: "
                        + obj.getDescripcion() + "\n Precio: " + obj.getPrezo());
                i++;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            dos.close();
        }
    }
}
