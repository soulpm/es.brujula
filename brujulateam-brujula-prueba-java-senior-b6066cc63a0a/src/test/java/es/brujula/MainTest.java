package es.brujula;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.brujula.dto.ActingProfessor;
import es.brujula.dto.AssociatedProfessor;
import es.brujula.dto.Professor;
import es.brujula.exception.BrujulaException;
import es.brujula.logic.DepartmentProfessors;

/**
 * Created by jramirez on 25/01/2017.
 */
public class MainTest {
   private static final String MATH_DEPARTMENT = "Math";
   private static final String IDIOMS_DEPARTMENT = "IDIOMS";
   private static final Integer YEARS_90 = 1997;
   private static final Integer YEARS_80 = 1987;
   private static final Integer YEARS_70 = 1977;
   public static final String JUAN = "Juan";
   public static final String ALABA = "Alaba";
   public static final String PEPE = "Pepe";
   public static final String BENEDICTO = "Benedicto";
   public static final String ZABALA = "Zabala";
   public static final String SUR_NAME_TO_LONG = "123456798012345678901";

   private Professor mainProfessor;
   private AssociatedProfessor associatedProfessor;
   private ActingProfessor actingProfessor;
   private Professor firstRepeatedProfessor;
   private Professor secondRepeatedProfessor;
   private Professor anotherProfessor;

   private DepartmentProfessors departmentProfessors;

   @Before	
   public void setUp() throws Exception {
      mainProfessor = new Professor(JUAN, ALABA, YEARS_80, MATH_DEPARTMENT);
      associatedProfessor = new AssociatedProfessor(JUAN, PEPE, YEARS_90, MATH_DEPARTMENT, LocalDate.now());
      actingProfessor = new ActingProfessor(JUAN, BENEDICTO, YEARS_70, MATH_DEPARTMENT, LocalDate.now());
      firstRepeatedProfessor = new Professor(JUAN, ALABA, YEARS_90, MATH_DEPARTMENT);
      secondRepeatedProfessor = new Professor(JUAN, BENEDICTO, YEARS_80, MATH_DEPARTMENT);
      anotherProfessor = new Professor(JUAN, ZABALA, YEARS_80, MATH_DEPARTMENT);

      departmentProfessors = new DepartmentProfessors(MATH_DEPARTMENT);
      departmentProfessors.addProfessor(mainProfessor);
      departmentProfessors.addProfessor(associatedProfessor);
      departmentProfessors.addProfessor(actingProfessor);
      //departmentProfessors.addProfessor(firstRepeatedProfessor);
      //departmentProfessors.addProfessor(secondRepeatedProfessor);
      departmentProfessors.addProfessor(anotherProfessor);
   }

   @After
   public void tearDown() {
      departmentProfessors = null;
   }

   @Test
   public void departmentProffessorsListingTest() {
      //GIVEN
      List<Professor> expectedOrderedProfessors = new ArrayList<>();
      expectedOrderedProfessors.add(mainProfessor);
      expectedOrderedProfessors.add(actingProfessor);
      expectedOrderedProfessors.add(associatedProfessor);
      expectedOrderedProfessors.add(anotherProfessor);
      //WHEN
      List<Professor> currentDepartmentProfessors = departmentProfessors.list();

      //THEN
      assertArrayEquals(expectedOrderedProfessors.toArray(), currentDepartmentProfessors.toArray());
   }
   @Test(expected = BrujulaException.class)
   public void professorEquityConditionsTest() throws Exception {
      //WHEN
      new Professor(JUAN, SUR_NAME_TO_LONG, YEARS_80, MATH_DEPARTMENT);
   }

   @Test(expected = BrujulaException.class)
   public void professorDepartmentConditionsTest() throws Exception {
      //GIVEN
      Professor distinctDeptartmentProfessor = new Professor(JUAN, ALABA, YEARS_80, IDIOMS_DEPARTMENT);
      //WHEN
      departmentProfessors.addProfessor(distinctDeptartmentProfessor);
   }

   @Test(expected = BrujulaException.class)
   public void actingProfessorDatesConditionTest() throws Exception {
      //GIVEN
      LocalDate actualLocalDate = LocalDate.now();
      LocalDate localDate = actualLocalDate.minusDays(1);

      //WHEN
      new ActingProfessor(JUAN, PEPE, YEARS_90, MATH_DEPARTMENT, localDate);
   }

   @Test
   public void professorCompleteNameTest() throws Exception {
      //GIVEN
      Professor currentProfessor = new Professor(JUAN, ZABALA, YEARS_70, IDIOMS_DEPARTMENT);
      String expectedProfessorCompleteName = new StringBuilder().append(ZABALA).append(", ").append(JUAN).toString();

      //WHEN
      String currentCompleteName = currentProfessor.getCompleteName();

      //THEN
      assertEquals(expectedProfessorCompleteName, currentCompleteName);
   }

   @Test
   public void personGetAgeTest() throws Exception {
      //GIVEN
      LocalDate localDate = LocalDate.now();

      LocalDate localDateYearOfBird = LocalDate.of(YEARS_70, 1, 1);
      int expectedAgeFor70s = Period.between(localDateYearOfBird, localDate).getYears();
      localDateYearOfBird = LocalDate.of(YEARS_80, 1, 1);
      int expectedAgeFor80s = Period.between(localDateYearOfBird, localDate).getYears();
      localDateYearOfBird = LocalDate.of(YEARS_90, 1, 1);
      int expectedAgeFor90s = Period.between(localDateYearOfBird, localDate).getYears();

      //WHEN
      int current70sProfessorAge = actingProfessor.getAge();
      int current80sProfessorAge = anotherProfessor.getAge();
      int current90sProfessorAge = associatedProfessor.getAge();
      
      //THEN
      assertEquals(expectedAgeFor70s, current70sProfessorAge);
      assertEquals(expectedAgeFor80s, current80sProfessorAge);
      assertEquals(expectedAgeFor90s, current90sProfessorAge);
   }
}