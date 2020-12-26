package ru.geekbrains.persist.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Product")  //@Table javax.persistence не HIBERNATE
@NamedQueries( {
        @NamedQuery(name = "Product.findMaxPrice",query ="SELECT max(p.price) from Product p") ,
@NamedQuery(name = "Product.findPoductByMaxPrice",query ="select p from Product p where p.price= ( select MAX (p.price) from Product p)" )
        })
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;





    public Product(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public  Product(Integer id, String title, BigDecimal price, Category category){
        this.id=id;
        this.title=title;
        this.price=price;
        this.category=category;
    }
    public  Product(Integer id,String title,BigDecimal price){
        this.id=id;
        this.title=title;
        this.price=price;
    }
    public void setId(Integer id) {
        this.id = id; }
    public int getId() {
        return id; }

    public void setTitle(String title) {
        this.title = title; }
    public String getTitle() {
        return title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price; }
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}' +  '\n';
    }

}
