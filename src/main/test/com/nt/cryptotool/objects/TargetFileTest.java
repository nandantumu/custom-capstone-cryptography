package test.com.nt.cryptotool.objects;

import com.nt.cryptotool.miscobjects.Task;
import com.nt.cryptotool.objects.TargetFile;
import com.nt.cryptotool.utils.Converter;
import com.nt.cryptotool.utils.PBox;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

/**
 * Created by Nandan on 3/21/2016.
 */
public class TargetFileTest {

    public TargetFile targetFile;
    public Converter converter;

    @Before
    public void setUp() throws Exception {
        targetFile = new TargetFile("C://Users/Nandan/Documents/MuseLog.txt", Task.Encrypt);
        converter = new Converter();
    }

    @After
    public void tearDown() throws Exception {
        targetFile.getTargetFile().delete();
    }

    @Test
    public void testGetFileName() throws Exception {
        System.out.print(targetFile.getFileName());
    }

    @Test
    public void testGetFileSize() throws Exception {
        System.out.print(targetFile.getFileSize());
    }


    @Test
    public void testGetContents() throws Exception {
        byte[] answer = targetFile.getBytesContents();
        BitSet answerSet = (converter.byteToBits(answer));
        System.out.println("Length of byte array: "+answer.length);
        System.out.println("Final byte val: "+answer[answer.length-1]);
        System.out.println("This is the length of the BitSet resulting: "+answerSet.length() +"Div by 8: "+ answerSet.length()/8 + "_"+ answerSet.length()%8);
        for(byte thebyte:answer){
            System.out.println((int)thebyte);
        }
    }

    @Test
    public void testFileOutput() throws Exception {
        FileUtils.writeByteArrayToFile(targetFile.getTargetFile(), PBox.combine(PBox.split(targetFile.getBitsContents())).toByteArray());
    }

    @Test
    public void testOutputLength() throws Exception {
        System.out.print(targetFile.getBitsContents().get(8636));
        System.out.print(targetFile.getBitsContents().get(8637));
        System.out.print(targetFile.getBitsContents().get(8638));
        System.out.print(targetFile.getBitsContents().get(8639));
        assertEquals(targetFile.getBitsContents().size(),targetFile.getBytesContents().length*8);
    }
}