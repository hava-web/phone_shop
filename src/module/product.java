package module;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
public class product {
   private long id;
   private String name;
   private String type;
   private double price;
   private Date importDate;
   private String madeIn;
   private String description;
   
   
   
public product(long id, String name, String type, double price, Date importDate, String madeIn, String description) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.price = price;
	this.importDate = importDate;
	this.madeIn = madeIn;
	this.description = description;
}
public product() {
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getImportDate() {
	return importDate;
}
public void setImportDate(Date importDate) {
	this.importDate = importDate;
}
public String getMadeIn() {
	return madeIn;
}
public void setMadeIn(String madeIn) {
	this.madeIn = madeIn;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "product [id=" + id + ", name=" + name + ", type=" + type +", Price" + price + ", importDate=" + importDate + ", Made In="
			+ madeIn + ", Description=" + description + "]";
}



}
