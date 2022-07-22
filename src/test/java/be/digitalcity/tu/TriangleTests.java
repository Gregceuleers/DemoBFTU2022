package be.digitalcity.tu;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


/*
    Un programme prend en entrée trois entiers. Ces trois entiers sont
interprétés comme représentant les longueurs des cotés d’un triangle.
Le programme rend un résultat précisant s’il s’agit d’un triangle scalène,
isocèle ou équilatéral.
     */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TriangleTests {
    private final Triangle triangle = new Triangle(3, 4, 5);

    @Nested
    class TestsEchecsValidationTriangle {

        @Test
        void uneValeurVautZeroTest_A() {
            triangle.setA(0);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_ZERO, exeption.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_B() {
            triangle.setB(0);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_ZERO, exeption.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_C() {
            triangle.setC(0);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_ZERO, exeption.getMessage());
        }

        @Test
        void uneValeurEstPlusPetiteQueZeroTest_A() {
            triangle.setA(-1);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_NEGATIF, exeption.getMessage());
        }

        @Test
        void uneValeurEstPlusPetiteQueZeroTest_B() {
            triangle.setB(-1);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_NEGATIF, exeption.getMessage());
        }

        @Test
        void uneValeurEstPlusPetiteQueZeroTest_C() {
            triangle.setC(-1);

            TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
            assertEquals(Utils.COTE_NEGATIF, exeption.getMessage());
        }

        @Test
        void sommeDeAetBEstInferieurOuEgalA_C() {
            assertAll("SommeCotes_C",
                    () -> {
                        triangle.setC(7);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_EGAL_TROISIEME, exeption.getMessage());
                    },
                    () -> {
                        triangle.setC(9);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_INF_TROISIEME, exeption.getMessage());

                    }
            );


        }

        @Test
        void sommeDeAetCEstInferieurOuEgalA_B() {
            assertAll("SommeCotes_B",
                    () -> {
                        triangle.setB(8);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_EGAL_TROISIEME, exeption.getMessage());
                    },
                    () -> {
                        triangle.setB(9);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_INF_TROISIEME, exeption.getMessage());

                    }
            );


        }

        @Test
        void sommeDeBetCEstInferieurOuEgalA_A() {
            assertAll("SommeCotes_A",
                    () -> {
                        triangle.setA(9);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_EGAL_TROISIEME, exeption.getMessage());
                    },
                    () -> {
                        triangle.setA(10);

                        TriangleExeption exeption = assertThrows(TriangleExeption.class, triangle::checkValidity);
                        assertEquals(Utils.SOMME_COTES_INF_TROISIEME, exeption.getMessage());

                    }
            );


        }


    }

    @Nested
    class TestsReussiteValidationTriangle {

        @Test
        void triangleEstEquilateral() throws TriangleExeption {
            triangle.setB(3);
            triangle.setC(3);
            assertEquals(TypeTriangle.EQUILATERAL, triangle.checkValidity());
        }

        @Test
        void triangleEstIsocele() throws TriangleExeption {
            triangle.setB(3);
            assertEquals(TypeTriangle.ISOCELE, triangle.checkValidity());
        }

        @Test
        void triangleEstScalene() throws TriangleExeption {
            assertEquals(TypeTriangle.SCALENE, triangle.checkValidity());
        }
    }
}
