/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rotation;

import java.awt.image.BufferedImage;

/**
 *
 * @author jonat
 */
public class Rotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // 1- Read an image:
        BufferedImage inImage = ImageIo.readImage("UTB.jpg");
        ImageIo.getBufferedImageType(inImage,"Main-Example-01: InImage");
        
        // 2- Convert to Gray (3-channels go to one)
        BufferedImage grayImage = ImageIo.toGray(inImage);
        ImageIo.writeImage(grayImage, "jpg", "UTB-gray.jpg");
        
        // 3 Extract 2-d byte arrays
        //Get 1 array
        byte[][] byteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);
        
        // Processing..
        GeometricOperations obj = new GeometricOperations();
        byte[][] rotatedDataF = obj.rotate_f(byteData, 30);
        byte[][] rotatedDataB = obj.rotate_b(byteData, 30);
        
        
        
        // 5- Put back in buffered image
        BufferedImage outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(rotatedDataF);
        BufferedImage outImage2 = ImageIo.setGrayByteImageArray2DToBufferedImage(rotatedDataB);

        // 6- Write out as file
        ImageIo.writeImage(outImage, "jpg", "rotated_30_f.jpg");
        ImageIo.writeImage(outImage2, "jpg", "roated_30_b.jpg");
        
    }
    
}
