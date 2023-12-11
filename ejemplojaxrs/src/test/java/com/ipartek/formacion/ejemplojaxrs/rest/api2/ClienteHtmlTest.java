package com.ipartek.formacion.ejemplojaxrs.rest.api2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;

public class ClienteHtmlTest {
	@Test
	void listado() {
		WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/ejemplojaxrs/clientes.html");

        assertEquals("Listado de clientes", driver.getTitle());

        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        
        assertEquals("Listado de clientes", h1.getText());
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}        
        
        WebElement ul = driver.findElement(By.cssSelector("ul"));
        
        ClienteServicio servicio = Globales.FABRICA.getServicioCliente();

        Collection<Cliente> clientes = servicio.obtenerClientes();
        
        clientes.forEach(cliente -> {
        	assertTrue(ul.getText().contains(cliente.getNombre()));
        });
        
        driver.quit();
	}
}
