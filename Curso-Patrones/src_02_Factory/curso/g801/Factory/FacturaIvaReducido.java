package curso.g801.Factory;
 
public class FacturaIvaReducido extends Factura{
 
@Override
 public double getImporteIva() {
 // TODO Auto-generated method stub
 return getImporte()*1.07;
 }
 
}