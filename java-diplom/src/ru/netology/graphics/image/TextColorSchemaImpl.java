package ru.netology.graphics.image;

public class TextColorSchemaImpl implements TextColorSchema {
    private final char[] chars = {'#', '$', '@', '%', '*', '+', '-', '\''};

    @Override
    public  char convert(int color) {
        return chars[color * (chars.length - 1) /255];
    }
}
