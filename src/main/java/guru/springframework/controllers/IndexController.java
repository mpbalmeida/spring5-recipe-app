package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnityOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.UnityOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnityOfMeasureRepository unityOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnityOfMeasureRepository unityOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnityOfMeasure> unityOfMeasureOptional = unityOfMeasureRepository.findByDescription("Cup");

        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("UOM id is: " + unityOfMeasureOptional.get().getId());

        return "index";
    }
}
