package gt.com.umg.aisolis.models;

/**
 *
 * @author aisolis
 */
public class Product {
    
    private int cod_prod;
    private String name;
    private int Stock;
    private double price;
    private String description;
    private String whatIs;
    private String forWhat;
    private String benefits;
    private String ussageWay;
    private String ingredients;
    private String warnings;
    private String status;
    
    private int quantity;
    private double subtotal;

    public Product() {
    }

    public Product(int cod_prod, String name, int Stock, double price, String description, String whatIs, String forWhat, String benefits, String ussageWay, String ingredients, String warnings, String status) {
        this.cod_prod = cod_prod;
        this.name = name;
        this.Stock = Stock;
        this.price = price;
        this.description = description;
        this.whatIs = whatIs;
        this.forWhat = forWhat;
        this.benefits = benefits;
        this.ussageWay = ussageWay;
        this.ingredients = ingredients;
        this.warnings = warnings;
        this.status = status;
    }

    public Product(String name, int Stock, double price, String description, String whatIs, String forWhat, String benefits, String ussageWay, String ingredients, String warnings, String status) {
        this.name = name;
        this.Stock = Stock;
        this.price = price;
        this.description = description;
        this.whatIs = whatIs;
        this.forWhat = forWhat;
        this.benefits = benefits;
        this.ussageWay = ussageWay;
        this.ingredients = ingredients;
        this.warnings = warnings;
        this.status = status;
    }
    
    

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getUssageWay() {
        return ussageWay;
    }

    public void setUssageWay(String ussageWay) {
        this.ussageWay = ussageWay;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "cod_prod=" + cod_prod + ", name=" + name + ", Stock=" + Stock + ", price=" + price + ", description=" + description + ", whatIs=" + whatIs + ", forWhat=" + forWhat + ", benefits=" + benefits + ", ussageWay=" + ussageWay + ", ingredients=" + ingredients + ", warnings=" + warnings + ", status=" + status + '}';
    }

    
    
}
