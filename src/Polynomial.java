//import java.util.Iterator;

public class Polynomial {
    List representation;

    /**
     * Debe crear de objeto Polynomial igual
     * al polinomio 0 (cero) , grado n=0 .
     */
    Polynomial() {
        representation = new MyLinkedList2();
    }

    /**
     * Debe crear un objeto Polynomial cuyo grado
     * sea igual al tamaño del arreglo coef , y cuyos
     * coeficientes sean tomados uno a uno desde el mismo arreglo
     * coef que entra como parámetro, en orden inverso (osea que
     * el primer valor del arreglo coef corresponde al exponente
     * más bajo de x , osea x=0).
     * Pero considerando que si algún casillero coef[k] es cero,
     * entonces el término correspondiente en el polinomio
     * no existe y no debe agregarse.
     *
     * @param coef
     */
    Polynomial(int[] coef) {
        representation = new MyLinkedList2();
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                representation.add(new MyLinkedList2.Nodo(coef[i], i));
            }
        }
    }

    /**
     * Retorna un Polynomial igual a la suma
     * entre this y pol.
     *
     * @param pol
     * @return
     */
    Polynomial add(Polynomial pol) {

        Iterator pol1 = this.representation.iterator();
        Iterator pol2 = pol.representation.iterator();

        MyLinkedList2.Nodo pol1Node = null, pol2Node = null;
        boolean pol1ChangeFlag = false, pol2ChangeFlag = false;

        Polynomial result = new Polynomial();

        while (pol1.hasNext() || pol2.hasNext()) {

            if (pol1Node == null || pol1ChangeFlag) {
                pol1Node = pol1.next();
            }
            if (pol2Node == null || pol2ChangeFlag) {
                pol2Node = pol2.next();
            }

            pol1ChangeFlag = false;
            pol2ChangeFlag = false;

            if (pol1Node.exponent > pol2Node.exponent) {


                MyLinkedList2.Nodo resultNode = new MyLinkedList2.Nodo(pol1Node.coefficient, pol1Node.exponent);


                result.representation.add(resultNode);
                if (pol1.hasNext()) {
                    pol1ChangeFlag = true;
                }
            } else if (pol1Node.exponent < pol2Node.exponent) {


                MyLinkedList2.Nodo resultNode = new MyLinkedList2.Nodo(pol2Node.coefficient, pol2Node.exponent);


                result.representation.add(resultNode);
                /*if(pol2.hasNext()){pol2Node=pol2.next();}*/
                if (pol2.hasNext()) {
                    pol2ChangeFlag = true;
                }
            } else if (pol1Node.exponent == pol2Node.exponent) {


                MyLinkedList2.Nodo resultNode = new MyLinkedList2.Nodo(pol1Node.coefficient + pol2Node.coefficient, pol1Node.exponent);


                result.representation.add(resultNode);
                if (pol1.hasNext()) {
                    pol1ChangeFlag = true;
                }
                if (pol2.hasNext()) {
                    pol2ChangeFlag = true;
                }
            }

        }

        return result;
    }

    /**
     * Devuelve el valor del coeficiente
     * del grado x.
     *
     * @param x
     * @return
     */
    int getCoefficient(int x) {
        int coefGradoX = 0;
        Iterator it = (Iterator) representation.iterator();
        while (it.hasNext()) {
            MyLinkedList2.Nodo aux = (MyLinkedList2.Nodo) it.next();
            if (aux.exponent == x) {
                coefGradoX += aux.coefficient;
            }
        }
        return coefGradoX;
    }

    /**
     * Establece el valor del coeficiente
     * de grado x al valor coef.
     * Sólo modifica, no agrega coeficientes
     * que a la hora de crearse el Polynomial
     * fueron 0, a fin de tener polinomios
     * que puedan no empezar con su coeficiente
     * mayor, lo cual entorpecería el uso de
     * otros métodos.
     *
     * @param x
     * @param coef
     */
    void setCoefficient(int x, int coef) {

        Iterator ita = representation.iterator();

        Iterator it = representation.iterator();
        while (it.hasNext()) {
            MyLinkedList2.Nodo aux = (MyLinkedList2.Nodo) it.next();
            if (aux.exponent == x) {
                aux.coefficient = coef;
            }
        }
    }

    /**
     * Calcula y retorna el valor del polinomio
     * en el punto x.
     * Desambiguación :
     * https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero
     *
     * @param x
     * @return
     */
    float valueOf(float x) {
        float result = 0;
        Iterator it = (Iterator) representation.iterator();
        while (it.hasNext()) {
            MyLinkedList2.Nodo aux = (MyLinkedList2.Nodo) it.next();
            result += aux.coefficient * Math.pow(x, aux.exponent);
        }
        return result;
    }

    /**
     * Retorna true si this es igual a x ,
     * y false en caso contrario.
     *
     * @param x
     * @return
     */
    @Override
    public boolean equals(Object x) {
        if (x.getClass() == Polynomial.class) {
            if(((Polynomial) x).representation.size() == this.representation.size()){
                Iterator i = this.representation.iterator();
                Iterator j = ((Polynomial) x).representation.iterator();
                while (i.hasNext() && j.hasNext()){
                    MyLinkedList2.Nodo aux1,aux2;
                    aux1=i.next();
                    aux2=j.next();
                    if(aux1.coefficient != aux2.coefficient || aux1.exponent!=aux2.exponent){
                        return false;
                    }
                }
                return true;
            }else {
                return false;
            }

        }
        return false;
    }

    /**
     * Retorna la representación del Polynomial
     * en forma de String.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("P(x) = ");
        if (representation.size() == 0) {
            return resultString.append("0").toString();
        } else {
            Iterator it = (Iterator) representation.iterator();
            while (it.hasNext()) {
                MyLinkedList2.Nodo aux = (MyLinkedList2.Nodo) it.next();
                resultString.append(" + [(" + aux.coefficient + ")*(x^" + aux.exponent + ")]");
            }
            return resultString.toString();
        }
    }
}


