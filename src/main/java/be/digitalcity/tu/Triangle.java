package be.digitalcity.tu;

public class Triangle {
    private int A;
    private int B;
    private int C;

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public Triangle(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public TypeTriangle checkValidity() throws TriangleExeption {
        if (A == 0 || B == 0 || C == 0) throw new TriangleExeption(Utils.COTE_ZERO);
        if (A < 0 || B < 0 || C < 0) throw new TriangleExeption(Utils.COTE_NEGATIF);
        if (A + B == C || A + C == B || B + C == A) throw new TriangleExeption(Utils.SOMME_COTES_EGAL_TROISIEME);
        if (A + B < C || A + C < B || B + C < A) throw new TriangleExeption(Utils.SOMME_COTES_INF_TROISIEME);
        if (A == B && B == C) return TypeTriangle.EQUILATERAL;
        if (A == B || B == C || A == C) return TypeTriangle.ISOCELE;
        return TypeTriangle.SCALENE;
    }
}
