package DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 23.05.2016.
 */
public class MemoryDAO implements DAO {

    private Map<Integer, Product> products = new HashMap<>();

    public MemoryDAO() {

    }

    @Override
    public boolean create(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        products.addAll(this.products.values());
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        create(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getId());
    }
}
