package pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private int productId;
	private String productName;
    private String productDesc;
    private String productCategory;
    private float weight_lb;
	private float price;
    
    public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public float getPrice() {
			return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getWeight_lb() {
		return weight_lb;
	}

	public void setWeight_lb(float weight_lb) {
		this.weight_lb = weight_lb;
	}
   
}
