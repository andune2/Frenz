package com.live.macsephi;

import net.minecraft.server.SharedConstants;

public class BetterChatWrapper
{
    private static final int[] characterWidths = { 
        1, 9, 9, 8, 8, 8, 8, 7, 9, 8, 9, 9, 8, 9, 9, 9, 
        8, 8, 8, 8, 9, 9, 8, 9, 8, 8, 8, 8, 8, 9, 9, 9, 
        4, 2, 5, 6, 6, 6, 6, 3, 5, 5, 5, 6, 2, 6, 2, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 2, 2, 5, 6, 5, 6, 
        7, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 4, 6, 6, 
        3, 6, 6, 6, 6, 6, 5, 6, 6, 2, 6, 5, 3, 6, 6, 6, 
        6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 5, 2, 5, 7, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 3, 6, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 
        6, 3, 6, 6, 6, 6, 6, 6, 6, 7, 6, 6, 6, 2, 6, 6, 
        8, 9, 9, 6, 6, 6, 8, 8, 6, 8, 8, 8, 8, 8, 6, 6, 
        9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 
        9, 9, 9, 9, 9, 9, 9, 9, 9, 6, 9, 9, 9, 5, 9, 9, 
        8, 7, 7, 8, 7, 8, 8, 8, 7, 8, 8, 7, 9, 9, 6, 7, 
        7, 7, 7, 7, 9, 6, 7, 8, 7, 6, 6, 9, 7, 6, 7, 1 };

    private static final String allowedChars = SharedConstants.allowedCharacters;
    
    /* Warning cleanup: none of these are used. -morganm 9/11/12
     * 
    private static final char COLOR_CHAR = '\u00A7';
    private static final char SPACE_CHAR = ' ';
    private static final char OTHER_COLOR_CHAR = '&';
    private static final int CHAT_WINDOW_WIDTH = 320;
    private static final int CHAT_STRING_LENGTH = 119;
    */
    //Mackenzie - Understood exactly why as well, didn't have to research a thing! More forgotten code
    // it appears. :p

    public static String[] wrapText(String text)
    {
        StringBuilder builder = new StringBuilder();
        char colorChar = 'f';
        int lineWidth = 0;
        int lineLength = 0;
        int wordLength = 0;
        int wordWidth = 0;
        int lineIsGood = 0;
        int lastSpacePosition = 0;

        for (int i = 0; i < text.length(); i++)
        {
            char ch = text.charAt(i);

            if (((ch == '\u00A7') || (ch == '&')) && (i < text.length() - 1))
            {
                i++;
                colorChar = text.charAt(i);
                if (Character.toString(colorChar).matches("[0-9a-fA-F]"))
                {
                    builder.append('\u00A7').append(colorChar);
                }
                else
                {
                    builder.append("&").append(colorChar);
                }

            }
            else
            {
                int index = allowedChars.indexOf(ch);
                if (index == -1) continue; index += 32;

                int width = characterWidths[index];

                if (((ch == ' ' ? 1 : 0) | (i == text.length() - 1 ? 1 : 0)) != 0)
                {
                    if ((wordLength > 119) || (wordWidth > 320))
                    {
                        builder.delete(lineIsGood, builder.length()).append('\n');
                        i = lineIsGood;
                        lineLength = 0;
                        lineWidth = 0;
                        wordLength = 0;
                        wordWidth = 0;
                        lineIsGood = 0;
                        if ((colorChar == 'f') || (colorChar == 'F'))
                            continue;
                        builder.append('\u00A7').append(colorChar);

                        lineLength += 2;
                        wordLength += 2;
                    }
                    else if ((lineLength + 1 > 119) || (lineWidth + width >= 320))
                    {
                        builder.delete(lastSpacePosition, builder.length()).append('\n');
                        i = lastSpacePosition;
                        lineLength = 0;
                        lineWidth = 0;
                        wordLength = 0;
                        wordWidth = 0;
                        lineIsGood = 0;
                        if ((colorChar == 'f') || (colorChar == 'F'))
                            continue;
                        builder.append('\u00A7').append(colorChar);

                        lineLength += 2;
                        wordLength += 2;
                    }
                    else
                    {
                        wordLength = 0;
                        wordWidth = 0;
                        lastSpacePosition = i;
                    }
                }
                else {
                    if ((lineLength < 119) && (lineWidth < 320))
                    {
                        lineIsGood = i;
                    }

                    builder.append(ch);
                    lineLength++;
                    wordLength++;
                    lineWidth += width;
                    wordWidth += width;
                }
            }
        }
        return builder.toString().split("\n");
    }

    public static String[] wrapSharp(String text)
    {
        StringBuilder out = new StringBuilder();
        char colorChar = 'f';
        int lineWidth = 0;
        int lineLength = 0;
        int lineIsGood = 0;

        for (int i = 0; i < text.length(); i++)
        {
            char ch = text.charAt(i);

            if (((ch == '\u00A7') || (ch == '&')) && (i < text.length() - 1)) {
                i++; colorChar = text.charAt(i);
                if (Character.toString(colorChar).matches("[0-9a-fA-FkK]"))
                    out.append('\u00A7').append(colorChar);
                else {
                    out.append("&").append(colorChar);
                }
                lineLength += 2;
            }
            else
            {
                int index = allowedChars.indexOf(ch);
                if (index == -1) {
                    continue;
                }
                index += 32;

                int width = characterWidths[index];

                if ((lineLength + 1 > 119) || (lineWidth + width >= 320)) {
                    out.delete(lineIsGood, out.length()).append('\n');
                    i = lineIsGood;
                    lineLength = 0;
                    lineWidth = 0;
                    lineIsGood = 0;
                    if ((colorChar != 'f') && (colorChar != 'F')) {
                        out.append('\u00A7').append(colorChar);
                        lineLength += 2;
                    }
                }
                else
                {
                    out.append(ch);
                    lineLength++;
                    lineWidth += width;

                    if ((lineLength < 119) && (lineWidth < 320))
                        lineIsGood = i; 
                }
            }
        }
        return out.toString().split("\n");
    }
}
