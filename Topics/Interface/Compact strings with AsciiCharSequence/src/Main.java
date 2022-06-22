import java.util.*;

class AsciiCharSequence implements CharSequence {

    private byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(chars, start, end));
    }

    @Override
    public String toString() {
        return new String(chars);
    }
}