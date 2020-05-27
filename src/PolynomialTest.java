import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //Polynomial testPolynomial = new Polynomial();
    }

    @org.junit.jupiter.api.Test
    void shouldCreatePolynomialCero() {
        Polynomial cero = new Polynomial();
        assertTrue(cero.representation.size() == 0);
        assertEquals(cero.toString(),"P(x) = 0");
    }

    @org.junit.jupiter.api.Test
    void shouldCreatePolynomialWithArray() {
        int coef [] = {1,-2,0,4};
        Polynomial fromArray = new Polynomial(coef);
        String aux = "P(x) =  + [(4)*(x^3)] + [(-2)*(x^1)] + [(1)*(x^0)]";
        assertEquals(fromArray.toString(),aux);
    }

    @org.junit.jupiter.api.Test
    void add() {

        int coef [] = {1,1,1,1,1};
        int coef1 []= {61,1,61,61,6};
        int coef2 []= {16,16,51,61};
        int coef3 []= {0,6,0,51,0,3};

        Polynomial fromArray = new Polynomial(coef);
        Polynomial fromArray1 = new Polynomial(coef1);
        Polynomial fromArray2 = new Polynomial(coef2);
        Polynomial fromArray3 = new Polynomial(coef3);
        Polynomial result,result1,result2;

        result= fromArray.add(fromArray1);
        result1= fromArray1.add(fromArray2);
        result2= fromArray2.add(fromArray3);

        assertEquals(result.toString(),"P(x) =  + [(7)*(x^4)] + [(62)*(x^3)] + [(62)*(x^2)] + [(2)*(x^1)] + [(62)*(x^0)]");
        assertEquals(result1.toString(),"P(x) =  + [(6)*(x^4)] + [(122)*(x^3)] + [(112)*(x^2)] + [(17)*(x^1)] + [(77)*(x^0)]");
        assertEquals(result2.toString(),"P(x) =  + [(3)*(x^5)] + [(112)*(x^3)] + [(51)*(x^2)] + [(22)*(x^1)] + [(6)*(x^1)]");

    }

    @org.junit.jupiter.api.Test
    void getCoefficient() {
        int coef [] = {-6,-8,0,1};
        Polynomial fromArray = new Polynomial(coef);

        assertEquals(fromArray.getCoefficient(0),-6);
        assertEquals(fromArray.getCoefficient(1),-8);
        assertEquals(fromArray.getCoefficient(2),-0);
        assertEquals(fromArray.getCoefficient(3),1);
        assertEquals(fromArray.getCoefficient(4),0);
        assertEquals(fromArray.getCoefficient(5),0);

    }

    @org.junit.jupiter.api.Test
    void setCoefficient() {
        int coef [] = {3,7,-5,0,1};
        Polynomial fromArray = new Polynomial(coef);

        fromArray.setCoefficient(2,46);
        assertEquals(fromArray.getCoefficient(2),46);

        fromArray.setCoefficient(22,666);
        assertEquals(fromArray.getCoefficient(22),0);

        fromArray.setCoefficient(3,999);
        assertEquals(fromArray.getCoefficient(3),0);

        fromArray.setCoefficient(0,55);
        assertEquals(fromArray.getCoefficient(0),55);

        fromArray.setCoefficient(-1,55);
        assertEquals(fromArray.getCoefficient(-1),0);

    }

    @org.junit.jupiter.api.Test
    void valueOf() {
        int coef [] = {5,-3,0,1};
        Polynomial fromArray = new Polynomial(coef);

        assertEquals(fromArray.valueOf(0),5);
        assertEquals(fromArray.valueOf(1),3);
        assertEquals(fromArray.valueOf(-1),7);
        assertEquals(fromArray.valueOf(2),7);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {

        int coef [] = {5,-3,0,1};
        Polynomial fromArray = new Polynomial(coef);

        int coef1 [] = {1,1,1,1,1,1};
        Polynomial fromArray1 = new Polynomial(coef1);

        Polynomial fromArray2 = new Polynomial(coef);

        Object object = new Object();

        assertTrue(fromArray.equals(fromArray));
        assertTrue(fromArray.equals(fromArray2));
        assertFalse(fromArray.equals(fromArray1));
        assertFalse(fromArray.equals(object));

    }

    @org.junit.jupiter.api.Test
    void testToString() {
        // Not tested here since it's used to test constructors
        // and has been tested there.
        /*
        int coef [] = {1,-2,0,4};
        Polynomial fromArray = new Polynomial(coef);
        String aux = "P(x) =  + [(1.0)*(x^0.0)] + [(-2.0)*(x^1.0)] + [(4.0)*(x^3.0)]";
        assertEquals(fromArray.toString(),aux);

        Polynomial cero = new Polynomial();
        assertTrue(cero.representation.size() == 0);
        assertEquals(cero.toString(),"P(x) = 0");
        */
    }
}