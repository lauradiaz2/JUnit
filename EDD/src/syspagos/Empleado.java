package syspagos;

import excepciones.CargoException;
import excepciones.MesesTrabajoException;
import excepciones.NombreEmpleadoException;
import excepciones.NumeroEmpleadoException;

public class Empleado {

    private int numeroEmpleado;
    String nombreEmpleado;
    private int mesesTrabajo;
    boolean Directivo;
    Prima prima;


    public Prima calcularPrima (String numEmpleado, String nomEmpleado, String mesesT, String dir)
            throws NumeroEmpleadoException, NombreEmpleadoException, MesesTrabajoException, CargoException 
    {

        establecerNumeroEmpleado(numEmpleado);
        estableceNombreEmpleado(nomEmpleado);
        estableceMesesTrabajo(mesesT);
        establecerSerDirectivo(dir);

        if (getDirectivo() && getMesesTrabajo() >=12){
            setPrima(Prima.P1);
            return Prima.P1;
        }
        if(!getDirectivo() && getMesesTrabajo() >=12){
            setPrima(Prima.P2);
            return Prima.P2;
        }
        if (getDirectivo() && getMesesTrabajo()<12){
            setPrima(Prima.P3);
            return Prima.P3;
        }
        if (!getDirectivo() && getMesesTrabajo()<12){
            setPrima(Prima.P4);
            return Prima.P4;
        }
        throw new RuntimeException();
    }


    public void establecerNumeroEmpleado(String nEmpleado) throws NumeroEmpleadoException 
    {
        int n;
        if (nEmpleado.matches("^\\d{3}$")){
        	n= Integer.parseInt(nEmpleado);
        	if(n>000 && n<1000) {
        		setNumeroEmpleado(n);
        	} else
        		throw new NumeroEmpleadoException();
            
        }else
        throw new NumeroEmpleadoException();
        //String numeroCeros = String.valueOf(obj.format("%05d", numero));
    }


    public void estableceNombreEmpleado(String nombreEmpleado) throws NombreEmpleadoException 
    {
        if (nombreEmpleado.matches("^[a-zA-Z]{1,10}$")){
            setNombreEmpleado(nombreEmpleado);
        }else
        throw new NombreEmpleadoException();
    }


    public void estableceMesesTrabajo(String mesesT) throws MesesTrabajoException {
        int n;
        if (mesesT.matches("^\\d{3}$"))
        {
        	n= Integer.parseInt(mesesT);
        	if(n>=000 && n<1000) {
                setMesesTrabajo(n);
        	} else
        		throw new MesesTrabajoException();
        }else
        throw new MesesTrabajoException();
    }

    public void establecerSerDirectivo(String directivo) throws CargoException {
        char[] caracter= directivo.toCharArray();
        if (caracter[0] == '+' ){
            setDirectivo(true);
        }else if(caracter[0]=='-'){
            setDirectivo(false);
        }else
        throw new CargoException();
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    private void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    private void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getMesesTrabajo() {
        return mesesTrabajo;
    }

    private void setMesesTrabajo(int mesesTrabajo) {
        this.mesesTrabajo = mesesTrabajo;
    }

    public boolean getDirectivo() {
        return Directivo;
    }

    private void setDirectivo(boolean directivo) {
        Directivo = directivo;
    }

    public Prima getPrima() {
        return prima;
    }

    private void setPrima(Prima prima) {
        this.prima = prima;
    }
}
