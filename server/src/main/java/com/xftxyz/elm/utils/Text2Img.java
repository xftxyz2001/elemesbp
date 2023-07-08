package com.xftxyz.elm.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Base64;

public class Text2Img {

    // base64编码前缀
    public static final String base64Prefix = "data:image/png;base64,";

    // 获取头像
    public static String getAvatar(String name) {
        BufferedImage bi = createImage(name.substring(0, 1), "Arial", 48);
        return imageToBase64(bi);
    }

    public static BufferedImage createImage(String text, String fontName, int fontSize) {
        // 创建一个字体对象
        Font font = new Font(fontName, Font.PLAIN, fontSize);

        // 创建一个BufferedImage对象
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

        // 获取Graphics对象
        Graphics graphics = image.getGraphics();

        // 设置字体
        graphics.setFont(font);

        // 获取字体的字形信息
        FontMetrics fontMetrics = graphics.getFontMetrics();

        // 计算文本的宽度和高度
        int width = fontMetrics.stringWidth(text);
        int height = fontMetrics.getHeight();

        // 释放Graphics对象
        graphics.dispose();

        // 创建一个新的BufferedImage对象，用于绘制文本
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // 获取Graphics对象
        graphics = image.getGraphics();

        // 设置背景透明
        graphics.setColor(new Color(0, 0, 0, 0));
        graphics.fillRect(0, 0, width, height);

        // 设置字体和颜色
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        // 绘制文本
        graphics.drawString(text, 0, fontMetrics.getAscent());

        // 释放Graphics对象
        graphics.dispose();

        return image;
    }

    public static String imageToBase64(BufferedImage image) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            return base64Prefix + Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            System.out.println("图片转换为Base64失败：" + e.getMessage());
            return null;
        }
    }
}
