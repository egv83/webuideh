package ec.gob.uideh.comun;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.mail.internet.MimeUtility;
import org.primefaces.util.Base64;
//import sun.misc.BASE64Encoder;

public class sha1 {

    public sha1() {
        super();
    }

    public static String encrypt64(String texto) throws IllegalStateException {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA");// Instancia de generador SHA-1
        } catch (NoSuchAlgorithmException e) {
            // TODO: handle exception
            throw new IllegalStateException(e.getMessage());
        }
        try {
            md.update(texto.getBytes("UTF-8"));// Generaci�n de resumen de mensaje
        } catch (UnsupportedEncodingException e) {
            // TODO: handle exception
            throw new IllegalStateException(e.getMessage());
        }
        byte raw[] = md.digest(); // Obtenci�n del resumen de mensaje
        //String hash = (new BASE64Encoder()).encode(raw); // Traducci�n a BASE642 
        //System.out.println("CLAVE ENCRIPTADA CON ENCRYPT64: "+hash);
        
        String hash2=Base64.encodeToString(raw, true);
        return hash2;
    }
    
    public static byte[] encode64(byte[] b) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        OutputStream b64os = MimeUtility.encode(baos, "base64");

        b64os.write(b);

        b64os.close();

        return baos.toByteArray();

    }

    public static byte[] decode64(byte[] b) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);

        InputStream b64is = MimeUtility.decode(bais, "base64");
        byte[] tmp = new byte[b.length];

        int n = b64is.read(tmp);

        byte[] res = new byte[n];

        System.arraycopy(tmp, 0, res, 0, n);

        return res;

    }
}
