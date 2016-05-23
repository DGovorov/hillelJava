package DB;

/**
 * Created by User on 23.05.2016.
 */
public class DaoMain {

    public static void main(String[] args) {
        DAO<Product> DAO = new MemoryDAO();
        DAO.create(new Product(1, "wqeqw", "wqeqwe", 2423));
        DAO.create(new Product(1, "wqeqw", "wqeqwe", 2423));
        DAO.create(new Product(1, "wqeqw", "wqeqwe", 2423));
        DAO.create(new Product(1, "wqeqw", "wqeqwe", 2423));
        DAO.create(new Product(1, "wqeqw", "wqeqwe", 2423));

        workWithProducts(DAO);
    }

    private static void workWithProducts(DAO<Product> DAO) {
        Product product = DAO.findById(3);
        System.out.println("id = 3 " + product);

        product.setName("Crocodile");
        DAO.update(product);

        System.out.println("After croco update " + DAO.findAll());

        DAO.delete(product);

        DAO.create(new Product(6, "Giraffe", "Aftican animal", 1));

        System.out.println("after croco delete and giraffe create" + DAO.findAll());
    }

}
