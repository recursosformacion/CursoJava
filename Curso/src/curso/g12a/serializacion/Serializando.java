package curso.g12a.serializacion;

import java.io.Serializable;

public class Serializando implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9104287169449058185L;
	public int a;
	public String b;
	public char c;
	transient Object visitor;
}
/*
 * private void writeObject(java.io.ObjectOutputStream out) throws IOException
 * private void readObject(java.io.ObjectInputStream in) throws IOException,
 * ClassNotFoundException; private void readObjectNoData() throws
 * ObjectStreamException;
 */


/*
De objeto a byte[]

ByteArrayOutputStream bs= new ByteArrayOutputStream();
ObjectOutputStream os = new ObjectOutputStream (bs);
os.writeObject(unObjetoSerializable);  // this es de tipo DatoUdp
os.close();
byte[] bytes =  bs.toByteArray(); // devuelve byte[]

De byte[] a objeto

ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
ObjectInputStream is = new ObjectInputStream(bs);
ClaseSerializable unObjetoSerializable = (ClaseSerializable)is.readObject();
is.close();
*/