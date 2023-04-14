import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class filtro_blue {

    public static void main(String[] args) throws IOException {
        File arquivo = new File("C:\\Users\\endry\\Downloads\\tulips.png");
        BufferedImage imagem = ImageIO.read(arquivo);
        int altura = imagem.getHeight();
        int largura = imagem.getWidth();


        //pegando o valor de cada banda por pixel
        for (int linha = 0; linha < altura; linha++){
            for (int coluna = 0; coluna < largura; coluna++){
                int rgbPixel = imagem.getRGB(coluna,linha);
                Color corPixel = new Color(rgbPixel);
                int red = corPixel.getRed();
                int green = corPixel.getGreen();
                int blue = corPixel.getBlue();

            }
        }
        for (int linha = 0; linha < altura; linha++){
            for (int coluna = 0; coluna < largura; coluna++){
                int rgbPixel = imagem.getRGB(coluna,linha);
                Color corPixel = new Color(rgbPixel);
                Color novaCor1 = new Color(0,0,corPixel.getBlue());//filtro banda Blue
                imagem.setRGB(coluna,linha,novaCor1.getRGB());//aplicando o filtro
            }
        }


        if (ImageIO.write(imagem, "jpg", new File("C:\\Users\\endry\\Downloads\\tulipsBLUE.png")))
            System.out.println("Imagem salva com sucesso");
        else System.out.println("Erro ao salvar a imagem");
    }
}
