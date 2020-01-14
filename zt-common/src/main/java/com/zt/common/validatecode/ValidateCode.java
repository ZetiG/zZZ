package com.zt.common.validatecode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author changyuwei
 * @date 2019-08-16
 */
public class ValidateCode {

    /**
     * 图片的宽度
     */
    private int width = 160;

    /**
     * 图片的高度
     */
    private int height = 40;

    /**
     * 证码字符个数
     */
    private int codeCount = 5;

    /**
     * 验证码干扰线数
     */
    private int lineCount = 150;

    /**
     * 验证码
     */
    private String code = null;

    /**
     * 验证码图片Buffer
     */
    private BufferedImage buffImg = null;

    private char[] codeSequence = {'a', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm',
            'n', 'p', 'r', 't', 'u', 'v', 'w', 'x', 'y',
            '3', '4', '7', '8'};

    public ValidateCode() {
        this.createCode();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public ValidateCode(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public ValidateCode(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        int x = 0, fontHeight = 0, codeY = 0;
        int red = 0, green = 0, blue = 0;

        //每个字符的宽度
        x = width / (codeCount + 2);
        //字体的高度
        fontHeight = height - 2 - 6;
        codeY = height - 4 - 5;

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 生成随机数
        Random random = new Random();
        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 创建字体
        ImageFontByte imgFont = new ImageFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);

        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            // random.nextInt(255);
            red = 44;
            //random.nextInt(255);
            green = 57;
            // random.nextInt(255);
            blue = 69;
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }

        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            // modified #666
            // random.nextInt(255);
            red = 44;
            // random.nextInt(255);
            green = 57;
            // random.nextInt(255);
            blue = 69;
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i * 1.3f + 0.7f) * x, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        code = randomCode.toString();
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        try {
            ImageIO.write(buffImg, "png", sos);
        } finally {
            if (sos != null) {
                sos.close();
            }
        }
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }


}
