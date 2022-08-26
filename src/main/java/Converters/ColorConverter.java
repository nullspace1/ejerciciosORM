package Converters;

import javax.persistence.AttributeConverter;
import java.awt.*;

public class ColorConverter implements AttributeConverter<Color,String> {
    @Override
    public String convertToDatabaseColumn(Color color) {
        return color.toString();
    }

    @Override
    public Color convertToEntityAttribute(String nombreColor) {
        return Color.getColor(nombreColor);
    }
}
