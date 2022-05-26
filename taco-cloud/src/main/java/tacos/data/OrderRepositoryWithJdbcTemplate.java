package tacos.data;
 
import tacos.TacoOrder;
 
public interface OrderRepositoryWithJdbcTemplate {
 
  TacoOrder save(TacoOrder order);
  
}