package modulo2.wrappers;

public class Wrapper {

	public static void main(String[] args) {
		boolean bool = true;
		System.out.println(bool);
		
		Boolean boolWrapper = Boolean.FALSE;
		System.out.println(boolWrapper);
		
		char cha = 'c';
		Character chaWrapper = Character.valueOf(cha);
		System.out.println(chaWrapper);
		
		byte b = 8;
		Byte byteWrapper = Byte.valueOf(b);		
		System.out.println(byteWrapper);
		
		short s = 4;
		Short shortWrapper = Short.valueOf(s);
		System.out.println(shortWrapper);
		
		int a = 2;
		Integer intWrapper = Integer.valueOf(a);
		System.out.println(intWrapper);
		intWrapper = 1;
		System.out.println(intWrapper);
		
		long l = 2L;
		Long longWrapper = Long.valueOf(l);
		System.out.println(longWrapper);
		
		float f = 3f;
		Float fWrapper = Float.valueOf(f);
		System.out.println(fWrapper);
		
		double d = 3.1;
		Double dWrapper = Double.valueOf(d);
		System.out.println(dWrapper);
	}
}
