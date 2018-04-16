package guru.springframework.repository;

import guru.springframework.domain.UnityOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnityOfMeasureRepositoryIT {

    @Autowired
    UnityOfMeasureRepository unityOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {

        Optional<UnityOfMeasure> cup = unityOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", cup.get().getDescription());
    }
}