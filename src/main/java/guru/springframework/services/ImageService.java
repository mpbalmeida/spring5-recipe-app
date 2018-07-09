package guru.springframework.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Marcos Almeida on 09/07/2018
 */
public interface ImageService {

    void saveImageFile(Long l, MultipartFile file);
}
