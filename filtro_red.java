import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class filtro_red {

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
                Color novaCor = new Color(corPixel.getRed(),0,0);//filtro banda R
                imagem.setRGB(coluna,linha,novaCor.getRGB());//aplicando o filtro
          }
        }


        if (ImageIO.write(imagem, "jpg", new File("C:\\Users\\endry\\Downloads\\tulipsRED.png")))
            System.out.println("Imagem salva com sucesso");
        else System.out.println("Erro ao salvar a imagem");
    }
}