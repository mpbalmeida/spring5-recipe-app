package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySql implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapMySql(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L) {
            log.debug("Loading categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Fast Food");
        categoryRepository.save(cat4);

        Category cat5 = new Category();
        cat5.setDescription("Dip");
        categoryRepository.save(cat5);

        Category cat6 = new Category();
        cat6.setDescription("Vegan");
        categoryRepository.save(cat6);

        Category cat7 = new Category();
        cat7.setDescription("Avocado");
        categoryRepository.save(cat7);
    }

    private void loadUom() {
        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setDescription("Teaspoon");
        unitOfMeasureRepository.save(unitOfMeasure1);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setDescription("Tablespoon");
        unitOfMeasureRepository.save(unitOfMeasure2);

        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setDescription("Cup");
        unitOfMeasureRepository.save(unitOfMeasure3);

        UnitOfMeasure unitOfMeasure4 = new UnitOfMeasure();
        unitOfMeasure4.setDescription("Pinch");
        unitOfMeasureRepository.save(unitOfMeasure4);

        UnitOfMeasure unitOfMeasure5 = new UnitOfMeasure();
        unitOfMeasure5.setDescription("Ounce");
        unitOfMeasureRepository.save(unitOfMeasure5);

        UnitOfMeasure unitOfMeasure6 = new UnitOfMeasure();
        unitOfMeasure6.setDescription("Dash");
        unitOfMeasureRepository.save(unitOfMeasure6);

        UnitOfMeasure unitOfMeasure7 = new UnitOfMeasure();
        unitOfMeasure7.setDescription("Each");
        unitOfMeasureRepository.save(unitOfMeasure7);

        UnitOfMeasure unitOfMeasure8 = new UnitOfMeasure();
        unitOfMeasure8.setDescription("Pint");
        unitOfMeasureRepository.save(unitOfMeasure8);
    }
}
