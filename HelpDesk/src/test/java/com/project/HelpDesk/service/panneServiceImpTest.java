package com.project.HelpDesk.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.project.HelpDesk.model.panneModel;
import com.project.HelpDesk.repository.panneRepo;
import com.project.HelpDesk.service.panneServiceImp;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class panneServiceImpTest {

    @Mock
    private panneRepo panneRepository;

    @InjectMocks
    private panneServiceImp panneService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPanne() {
        panneModel panne = new panneModel();
        panne.setId(4L);
        panne.setDescription("TST");
        panne.setEtat("Broken");

        when(panneRepository.save(any(panneModel.class))).thenReturn(panne);

        panneModel result = panneService.addPanne(panne);

        assertNotNull(result);
        assertEquals(panne.getId(), result.getId());
        assertEquals(panne.getDescription(), result.getDescription());
        assertEquals(panne.getEtat(), result.getEtat());
    }
}
