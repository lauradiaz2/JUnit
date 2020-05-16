package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleado 
{
	

	@Test 
	public void establecerNumeroDeEmpleadoCorrecto() 
	{
		Empleado e = new Empleado();
        try 
        {
            e.establecerNumeroEmpleado("400");
        } catch (NumeroEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals(400,e.getNumeroEmpleado());
	}
	
	@Test
	public void establecerNombreEmpleadoCorrecto()
	{
		Empleado e = new Empleado();
        try 
        {
            e.estableceNombreEmpleado("Laura");
        } catch (NombreEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals("Laura",e.getNombreEmpleado());
	}

	@Test
	public void establecerMesesTrabajoCorrecto()
	{
		Empleado e = new Empleado();
        try 
        {
            e.estableceMesesTrabajo("013");
        } catch (MesesTrabajoException ex) 
        {
        	fail();
        }
        assertEquals(13,e.getMesesTrabajo());
	}
	
	@Test
	public void establecerSerDirectivoCorrecto()
	{
		Empleado e = new Empleado();
        try 
        {
            e.establecerSerDirectivo("+");
        } catch (CargoException ex) 
        {
        	fail();
        }
        assertEquals(true,e.getDirectivo());
	}
	
	@Test
	public void calcularPrimaCorrecto() throws NumeroEmpleadoException, NombreEmpleadoException, MesesTrabajoException
	{
		Empleado e = new Empleado();
		Prima resultado=P1;
        try 
        {
            resultado=e.calcularPrima("400", "Laura", "011", "-");
        } catch (CargoException ex) 
        {
        	fail();
        }
        assertEquals(P4,resultado);
	}
}
