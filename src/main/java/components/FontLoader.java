package components;

import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FontLoader {
     private static final String FONT_PATH = "src/main/resources/fonts/";
        private static final Map<String, Font> fontCache = new HashMap<>();

        public static Font loadFont(String fileName, int style, float size) {
            try {
                if (!fontCache.containsKey(fileName)) {
                    File fontFile = new File(FONT_PATH + fileName);
                    Font baseFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
                    fontCache.put(fileName, baseFont);
                }
                return fontCache.get(fileName).deriveFont(style, size);
            } catch (Exception e) {
                e.printStackTrace();
                return new Font("SansSerif", style, (int) size); // fallback
            }
        }
}
