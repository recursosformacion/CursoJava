package curso.g10.junit0;

import java.util.Calendar;

public class Movimiento {
	protected String mConcepto;
	protected Calendar mFecha;
	protected double mImporte;

	public Movimiento() {
		mFecha = Calendar.getInstance();
	}

	public double getImporte() {
		return mImporte;
	}

	public String getConcepto() {
		return mConcepto;
	}

	public void setConcepto(String newMConcepto) {
		mConcepto = newMConcepto;
	}

	public Calendar getFecha() {
		return mFecha;
	}

	public void setFecha(Calendar newMFecha) {
		mFecha = newMFecha;
	}

	public void setImporte(double newMImporte) {
		mImporte = newMImporte;
	}
	@Override
	public String toString() {
		return "Movimiento [mConcepto=" + mConcepto + ", mFecha=" + mFecha + ", mImporte=" + mImporte + "]";
	}

}
