package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code){
        String fileNamePath = "src/download/" + code + ".jpg";
        HttpStatusChecker downloadLink = new HttpStatusChecker();
        String url = downloadLink.getStatusImage(code);
        try (InputStream in = URI.create(url).toURL().openStream()){
            Files.copy(in, Paths.get(fileNamePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e){
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
