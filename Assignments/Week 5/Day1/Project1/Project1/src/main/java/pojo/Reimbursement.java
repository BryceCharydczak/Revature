package pojo;

import java.util.Objects;

public class Reimbursement {
    private int reimbursementID;
    private double amount;
    private String subTime;
    private String resTime;
    private String description;
    private int author;
    private int resolver;
    private int statusID;
    private int typeID;


    public Reimbursement(int reimbursementID, double amount, String subTime, String resTime, String description, int author, int resolver, int statusID, int typeID) {
        this.reimbursementID = reimbursementID;
        this.amount = amount;
        this.subTime = subTime;
        this.resTime = resTime;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.statusID = statusID;
        this.typeID = typeID;
    }

    public Reimbursement() {
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementID=" + reimbursementID +
                ", amount=" + amount +
                ", subTime='" + subTime + '\'' +
                ", resTime='" + resTime + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", statusID=" + statusID +
                ", typeID=" + typeID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return reimbursementID == that.reimbursementID &&
                Double.compare(that.amount, amount) == 0 &&
                author == that.author &&
                resolver == that.resolver &&
                statusID == that.statusID &&
                typeID == that.typeID &&
                Objects.equals(subTime, that.subTime) &&
                Objects.equals(resTime, that.resTime) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(reimbursementID, amount, subTime, resTime, description, author, resolver, statusID, typeID);
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public String getResTime() {
        return resTime;
    }

    public void setResTime(String resTime) {
        this.resTime = resTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
}
