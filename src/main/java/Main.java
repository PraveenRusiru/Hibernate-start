import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
//        Customer customer = new Customer("C001","Praveen","praveenrusiru752@gmail.com");
//saveCustomer(customer);
//        Customer customer2 = getAllCustomer("C001");
//        if (customer2!=null) {
//            System.out.println(customer2.getCustomerName()+" "+customer2.getEmail());
//        }else{
//            System.out.println("Customer not found");
//        }
//        if (!deleteCustomer("C001")){
//            System.out.println("Customer not found");
//        }
        Customer customer = new Customer("C002","fgfg","rusiru45@gmail.com");
        updateNewCustomer(customer);

    }
    public static boolean saveCustomer(Customer customer){
        Session session=FactoryConfiguration.getInstance().getSessionFactory();
        try {
            Transaction transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("Customer saved successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Fail to save");
            return false;
        }finally {
            session.close();
        }
    }
    public static Customer getAll(String id){
        Session session=FactoryConfiguration.getInstance().getSessionFactory();
        try {
            Transaction transaction=session.beginTransaction();
           Customer customer= session.load(Customer.class,id);
           transaction.commit();
            System.out.println("Customer loaded successfully");
          System.out.println(customer.getCustomerName()+" "+customer.getEmail());
           return customer;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Fail to load");
            return null;
        }finally {
            session.close();
        }
    }
    public static boolean deleteCustomer(String id){
        Session session=FactoryConfiguration.getInstance().getSessionFactory();
        try {
            Transaction transaction=session.beginTransaction();
            session.delete(session.load(Customer.class,id));
            transaction.commit();
            System.out.println("Customer deleted successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Fail to delete");
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateOldCustomer(Customer customer){
        Session session=FactoryConfiguration.getInstance().getSessionFactory();
        try {

            Transaction transaction=session.beginTransaction();
            session.update(customer);
            transaction.commit();
            System.out.println("Customer updated successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Fail to update");
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateNewCustomer(Customer customer){
        Session session=FactoryConfiguration.getInstance().getSessionFactory();
        try {
            Customer customer1=session.get(Customer.class,customer.getCustomerId());
            customer1.setCustomerName(customer.getCustomerName());
            customer1.setEmail(customer.getEmail());

            Transaction transaction=session.beginTransaction();

            transaction.commit();
            System.out.println("Customer updated successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Fail to update");
            return false;
        }finally {
            session.close();
        }
    }
}
