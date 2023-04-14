import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class cmedia {

    public static void main(String[] args) throws IOException {
        File arquivo = new File("C:\\Users\\endry\\Downloads\\tulips.png");
        BufferedImage imagem = ImageIO.read(arquivo);
        int altura = imagem.getHeight();
        int largura = imagem.getWidth();



        //pegando o valor de cada banda por pixel
        for (int i = 0; i < imagem.getHeight(); i++) {
            for (int j = 0; j < imagem.getWidth(); j++) {
                int rgb = imagem.getRGB(j, i);
                Color cor = new Color(rgb);
                //usando so os valores das 3 bandas para tira a media
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                Color novaCor = new Color(media, media, media);
                imagem.setRGB(j, i, novaCor.getRGB());

            }

        }
        if (ImageIO.write(imagem, "jpg", new File("C:\\Users\\endry\\Downloads\\tulipscmedia.png")))
            System.out.println("Imagem salva com sucesso");
        else System.out.println("Erro ao salvar a imagem");
    }
}
