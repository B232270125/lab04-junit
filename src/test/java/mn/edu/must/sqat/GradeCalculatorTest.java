package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradeCalculatorTest {

    @Test
    @DisplayName("Ердийн оноонууд зөв үсгэн дүн өгөх ёстой")
    void typicalValues() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals("A", calc.letterGrade(95));
        assertEquals("B", calc.letterGrade(85));
        assertEquals("C", calc.letterGrade(75));
        assertEquals("D", calc.letterGrade(65));
        assertEquals("F", calc.letterGrade(30));
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();   // Arrange
        String grade = calc.letterGrade(90.0);          // Act
        assertEquals("A", grade);                       // Assert
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой")
    void eightyNineNinetyNineIsB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(89.99);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой")
    void sixtyIsExactlyD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(60.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой")
    void fiftyNineNinetyNineIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(59.99);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 ба 100 оноо хүчинтэй хязгаар байх ёстой")
    void zeroAndHundredAreValid() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals("F", calc.letterGrade(0));
        assertEquals("A", calc.letterGrade(100));
    }

    @Test
    @DisplayName("Сөрөг оноо (-1) алдаа шидэх ёстой")
    void negativeScoreThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    @DisplayName("100-аас их оноо (101) алдаа шидэх ёстой")
    void scoreAbove100Throws() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    @DisplayName("Дээд оноонуудын нийлбэр 100 байх ёстой")
    void totalScoreMaximumIs100() {
        GradeCalculator calc = new GradeCalculator();
        double total = calc.totalScore(10, 40, 10, 10, 30);
        assertEquals(100.0, total, 0.0001);
    }

    @Test
    @DisplayName("Ирцийн оноо сөрөг (-5) бол алдаа шидэх ёстой")
    void totalScoreNegativeAttendanceThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30));
    }

    @Test
    @DisplayName("Лабын оноо дээд хязгаараас хэтэрвэл (41) алдаа шидэх ёстой")
    void totalScoreLabAboveMaxThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30));
    }
}