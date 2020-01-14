package com.zt.common.validatecode;

import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Description: 验证码字体类
 *
 * @Date 2020/1/14 20:08
 * @Author Zeti
 */
@NoArgsConstructor
public class ImageFontByte {

    private static byte[] fontBytes;

    static {
        try {
            fontBytes = getFontByteFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Font getFont(int fontHeight) {
        try {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(fontBytes));
            return baseFont.deriveFont(Font.PLAIN, fontHeight);
        } catch (Exception e) {
            return new Font("Arial", Font.PLAIN, fontHeight);
        }
    }

    /**
     * @return
     * @throws IOException
     */
    private static byte[] getFontByteFromFile() throws IOException {
        DataInputStream dis = new DataInputStream(ImageFontByte.class.getResourceAsStream("/vc/fonts.bin"));
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(34944);
        final int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        while (dis.read(buffer) > 0) {
            bytes.write(buffer);
            buffer = new byte[bufferSize];
        }
        dis.close();
        return bytes.toByteArray();
    }
}
