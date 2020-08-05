import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Random;

import javax.security.auth.login.AppConfigurationEntry;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pruebabanco.ConfiguradorSpring;
import com.pruebabanco.entity.Factura;
import com.pruebabanco.service.FacturaService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ConfiguradorSpring.class})
public class Test {
 
	@Autowired
    private FacturaService dependency;
     
    @org.junit.Test
    public void buscarUna(){
        assertEquals("Ropa", dependency.buscarUna(4).getConcepto());      
    }
    
    @org.junit.Test
    public void insertar(){
    	Random r = new Random();
    	int low = 10;
    	int high = 100;
    	int result = r.nextInt(high-low) + low;
    	dependency.insertar(new Factura(result, "Celular", 123));
        assertEquals("Celular", dependency.buscarUna(result).getConcepto());      
    }
    
    @org.junit.Test
    public void borrar(){
    	Random r = new Random();
    	int low = 10;
    	int high = 100;
    	int result = r.nextInt(high-low) + low;
    	dependency.insertar(new Factura(result, "Celular2", 123));
    	assertEquals("Celular2", dependency.buscarUna(result).getConcepto());
    	
    	FacturaService world = new FacturaService();
    	FacturaService spy = Mockito.spy(world);
    	Mockito.doNothing().when(spy).borrar(new Factura(result));
    	dependency.borrar(new Factura(result));   
    }

@org.junit.Test
    public void updateCustomer_doAnswer_when() {
    	FacturaService world = new FacturaService();
    	FacturaService spy = Mockito.spy(world);
    	Mockito.doThrow(IllegalArgumentException.class).when(spy).actualizar(new Factura(4, "Ropa", 298));
   
 
}
