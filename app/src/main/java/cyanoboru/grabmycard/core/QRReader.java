package cyanoboru.grabmycard.core;

/**gms
 * Created by Martín on 10/12/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

//AL FINAL HE RESULTADO SER UNA CLASE INUTIL
public class QRReader {

    public static String Read(Context context){
        //Inicializa el detector de barcodes
        BarcodeDetector detector = new BarcodeDetector.Builder(context).setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE).build();

        //Crea un frame con la imagen, y devuelve un array de los barcodes que haya en la imagen
        Bitmap TODO = null; //Esto tiene que cambiar como es obvio
        Frame frame = new Frame.Builder().setBitmap(TODO).build();
        SparseArray<Barcode> barcodes = detector.detect(frame);

        //Si solo se va a leer 1 qr al mismo tiempo...
        Barcode QR = barcodes.valueAt(0);
        return QR.rawValue;
    }
}
