package gym.com.br.mylocalgym.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Luciano on 30/10/2016.
 */

public class Img implements Serializable{

    public Bitmap bitmap;

    public Img(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    private void writeObject(ObjectOutputStream out){

        ByteArrayOutputStream byteSteam = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteSteam);
        byte bitmapBytes[] = byteSteam.toByteArray();
        try {
            out.write(bitmapBytes, 0, bitmapBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream inputStream) throws IOException {

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int b;
        while((b = inputStream.read()) != -1)
            byteStream.write(b);
        byte bitmapBytes[] = byteStream.toByteArray();
        bitmap = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);

    }

}
