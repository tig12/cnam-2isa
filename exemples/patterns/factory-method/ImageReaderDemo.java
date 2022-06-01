/** 
    Adaptation de https://sourcemaking.com/design_patterns/factory_method/java/1
**/

interface ImageReader {
    DecodedImage getDecodedImage();
}

class DecodedImage {
    private String image;

    public DecodedImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is decoded";
    }
}

class GifReader implements ImageReader {
    private DecodedImage decodedImage;

    public GifReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {
    private DecodedImage decodedImage;

    public JpegReader(String image) {
        decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}

public class ImageReaderDemo {
    public static void main(String[] args) {
        String usage = "usage : ImageReaderDemo <image file>\n  <image file> must end by '.gif' or '.jpeg' or '.jpg'";
        if(args.length != 1){
            System.out.println(usage);
            System.exit(0);
        }
        
        String image = args[0];
        DecodedImage decodedImage;
        ImageReader reader = null;
        String format = image.substring(image.indexOf('.') + 1, (image.length()));
        
        if(!format.equals("gif") && !format.equals("jpeg") && !format.equals("jpg")){
            System.out.println(usage);
            System.out.printf("valeur fournie : '%s'\n", image);
            System.exit(0);
        }
        
        if (format.equals("gif")) {
            reader = new GifReader(image);
        }
        if (format.equals("jpeg") || format.equals("jpg")) {
            reader = new JpegReader(image);
        }
        
        decodedImage = reader.getDecodedImage();
        System.out.println(decodedImage);
    }
}