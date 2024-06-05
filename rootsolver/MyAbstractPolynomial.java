public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int deg = degree();
        for (int i = 0; i <= deg; i++) {
            if (i > 0) sb.append(" + ");
            sb.append(coefficientAt(i));
            if (i == 1) sb.append("x");
            else if (i > 1) sb.append("x^").append(i);
        }
        sb.append("]");
        return sb.toString();
        /* TODO */
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        int deg = degree();
        if (deg == 0) return new double[]{0.0};
        double[] result = new double[deg];
        for (int i = 1; i <= deg; i++) {
            result[i - 1] = coefficientAt(i) * i;
        }
        return result;
        /* TODO */
    }
}