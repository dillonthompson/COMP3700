package edu.auburn;

public class CustomerModel {
    public int mcustomerID;
    public String mName, mAddress, mPhone;

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mcustomerID).append(",");
        sb.append("\"").append(mName).append("\"").append(",");
        sb.append("\"").append(mAddress).append("\"").append(",");
        sb.append("\"").append(mPhone).append("\"").append(")");
        return sb.toString();
    }
}
