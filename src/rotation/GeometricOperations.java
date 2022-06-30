/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rotation;

/**
 *
 * @author jonat
 */
public class GeometricOperations {
    
    public byte[][] rotate_f(byte[][] input, float theta) {
        byte[][] rotatedData = new byte[input.length][input[0].length];
        double costerm = Math.cos(theta * Math.PI / 180.00);   // Radians
        double sinterm = Math.sin(theta * Math.PI / 180.00);   // Radians
        
        int h = input.length;
        int w = input[0].length;
        int new_i, new_j;
        
        // bottom rows
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                new_i = (int) (i * costerm + j * sinterm);
                new_j = (int) (-i * sinterm + j * costerm);
                
                if (new_i > 0 && new_i < h && new_j > 0 && new_j < w)
                    rotatedData[new_i][new_j] = input[i][j];
            }
        }
        return rotatedData;
    }
    
    public byte[][] rotate_b(byte[][] input, float theta) {
        byte[][] rotatedData = new byte[input.length][input[0].length];
        double costerm = Math.cos(theta * Math.PI / 180.00);   // Radians
        double sinterm = Math.sin(theta * Math.PI / 180.00);   // Radians
        
        int h = input.length;
        int w = input[0].length;
        int old_i, old_j;
        
        // bottom rows
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                old_i = (int) (i * costerm - j * sinterm);
                old_j = (int) (i * sinterm + j * costerm);
                
                if (old_i > 0 && old_i < h && old_j > 0 && old_j < w)
                    rotatedData[i][j] = input[old_i][old_j];
                else
                    rotatedData[i][j] = (byte) 0;
            }
        }
        return rotatedData;
    }
}
