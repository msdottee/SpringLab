package co.grandcircus.springlab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GradeIntegrationTest {

    @Autowired
    private GradeDao gradeDao;

    @BeforeEach
    public void testDataSetUp() {
        for (Grade grade : gradeDao.findAll()) {
            gradeDao.delete(grade.getId());
        }
        Grade grade1 = new Grade("African Countries Worksheet", "Assignment", new BigDecimal(10), new BigDecimal(10));
        Grade grade2 = new Grade("Central Asian Languages Quiz", "Quiz", new BigDecimal(2), new BigDecimal(10));
        Grade grade3 = new Grade("Mid-Term Exam", "Exam", new BigDecimal(43), new BigDecimal(50));
        gradeDao.create(grade1);
        gradeDao.create(grade2);
        gradeDao.create(grade3);
    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void indexRedirectsToGrades() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/grades"));
    }

    @Test
    public void listShowsListOfGrades() throws Exception {
        mvc.perform(get("/grades"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("grades", hasSize(3)));
    }

    @Test
    public void listCalculatesOverallGrade() throws Exception {
        mvc.perform(get("/grades"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("totalGrade", is(new BigDecimal("78.6"))));
    }

    @Test
    public void showAddPage() throws Exception {
        mvc.perform(get("/grades/add"))
                .andExpect((status().isOk()));
    }

    @Test
    public void addConfirmationPageAddsGradeToDatabase() throws Exception {
        mvc.perform(post("/grades/addconfirmation")
                .param("name", "Java Test")
                .param("type", "Test")
                .param("score", String.valueOf(new BigDecimal(49)))
                .param("total", String.valueOf(new BigDecimal(50))))
                .andExpect(status().isOk());
        Grade createdGrade = gradeDao.findAll().get(3);
        assertThat(createdGrade.getName()).isEqualTo("Java Test");
        assertThat(createdGrade.getType()).isEqualTo("Test");
        assertThat(createdGrade.getScore()).isEqualTo(new BigDecimal("49.0"));
        assertThat(createdGrade.getTotal()).isEqualTo(new BigDecimal("50.0"));
        assertThat(createdGrade.getPercentage()).isEqualTo(new BigDecimal("98.0"));
    }

    @Test
    public void displayDetailPageDisplaysGrade() throws Exception {
        Grade gradeToDisplay = gradeDao.findAll().get(0);
        mvc.perform(get("/grades/detail")
                .queryParam("id", gradeToDisplay.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("grade", hasProperty("name",
                        is("African Countries Worksheet"))))
                .andExpect(model().attribute("grade", hasProperty("type",
                        is("Assignment"))))
                .andExpect(model().attribute("grade", hasProperty("score",
                        is(new BigDecimal("10.0")))))
                .andExpect(model().attribute("grade", hasProperty("total",
                        is(new BigDecimal("10.0")))));
    }

    @Test
    public void displayDetailPageDisplaysNotFoundOnMissingGrade() throws Exception {
        mvc.perform(get("/grades/detail")
                .queryParam("id", "-1"))
                .andExpect(content().bytes(new byte[0]));
    }

    @Test
    public void deleteConfirmationDisplaysGradeToBeDeleted() throws Exception {
        Grade gradeToDisplay = gradeDao.findAll().get(0);
        mvc.perform(get("/grades/deleteconfirmation")
        .queryParam("id", gradeToDisplay.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("grade", hasProperty("name",
                        is("African Countries Worksheet"))));
    }

    @Test
    public void deleteConfirmationDisplaysNotFoundOnMissingGrade() throws Exception {
        mvc.perform(get("/grades/deleteconfirmation")
                .queryParam("id", "-1"))
                .andExpect(content().bytes(new byte[0]));
    }

    @Test
    public void deleteRedirectsToGradesAndDeletesGrade() throws Exception {
        Grade gradeToDisplay = gradeDao.findAll().get(0);
        mvc.perform(delete("/grades/delete")
                .queryParam("id", gradeToDisplay.getId().toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/grades"));

        assertThat(gradeDao.findById(gradeToDisplay.getId())).isEmpty();
    }
}
