package guru.springframework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Marcos Almeida on 09/07/2018
 */
@Slf4j
@Service
public class imageServiceImpl implements ImageService {

    @Override
    public void saveImageFile(Long l, MultipartFile file) {
        log.debug("image received");
    }
}
