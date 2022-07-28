package eu.horasion.intermediate.superobject;

import java.util.Arrays;
import java.util.Objects;

public class SuperObjectDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		IdCard adminCard = new IdCard("Manfred", 521890524622L, (short)2019);

		// Type casting to IdCard is mandatory! Because the 'clone' method from
		// "superobject" Object can not be used directly, it can only be used
		// from classes which override the 'clone' method.
		IdCard adminCard2 = (IdCard)adminCard.clone();

		// These will use the Object's default toString methods, outputting
		// the complete class name, plus @, plus memory address.
		System.out.println(adminCard.toString());
		System.out.println(adminCard2.toString());

		// This will return 'false', although both have the same content.
		// The reason is that 'equals' method also checks the hashCodes of both.
		// The 'clone' method creates a COPY, therefore a different mem address.
		System.out.println(adminCard.equals(adminCard2));
		// Same result gives the static method 'equals' of Objects class,
		// the main difference is that it checks for null and then runs the
		// 'equals' method of the first argument (here adminCard).
		System.out.println(Objects.equals(adminCard, adminCard2));

		System.out.println("----------------\nVISITORS:");

		VisitCard visitor1 = new VisitCard("Lucas", 3015456680647L, (short)2022);

		VisitCard visitor2 = (VisitCard)visitor1.clone();

		System.out.println(visitor1.equals(visitor2));
		// Same result gives the static method 'equals' of Objects class,
		// the main difference is that it checks for null and then runs the
		// 'equals' method of the first argument (here visitor1).
		System.out.println(Objects.equals(visitor1, visitor2));

		System.out.println("----------------\nOBJECT DETAILS:");

		System.out.println(visitor1.getClass().getName());
		System.out.println(visitor1.getClass().getSimpleName());

		System.out.println(visitor1.getClass().getFields()); // with mem address
		System.out.println("### getFields:");
		System.out.println(Arrays.toString(visitor1.getClass().getFields()));
		System.out.println("### getDeclaredFields:");
		System.out.println(Arrays.toString(visitor1.getClass().getDeclaredFields()));
		System.out.println("### getMethods:");
		System.out.println(Arrays.toString(visitor1.getClass().getMethods()));
		System.out.println("### getDeclaredMethods:");
		System.out.println(Arrays.toString(visitor1.getClass().getDeclaredMethods()));
		System.out.println("### getSuperclass:");
		System.out.println(visitor1.getClass().getSuperclass());

		System.out.println("### hashCode visitor1 and visitor2:");
		System.out.println(visitor1.hashCode());
		System.out.println(visitor2.hashCode());
	}

}

/*

eu.horasion.intermediate.superobject.IdCard@4617c264
eu.horasion.intermediate.superobject.IdCard@36baf30c
false
false
----------------
VISITORS:
true
true
----------------
OBJECT DETAILS:
eu.horasion.intermediate.superobject.VisitCard
VisitCard
[Ljava.lang.reflect.Field;@4517d9a3
### getFields:
[]
### getDeclaredFields:
[java.lang.String eu.horasion.intermediate.superobject.VisitCard.name, long eu.horasion.intermediate.superobject.VisitCard.cardNumber, short eu.horasion.intermediate.superobject.VisitCard.yearPrinted]
### getMethods:
[public java.lang.String eu.horasion.intermediate.superobject.VisitCard.getName(), public boolean eu.horasion.intermediate.superobject.VisitCard.equals(java.lang.Object), public short eu.horasion.intermediate.superobject.VisitCard.getYearPrinted(), public long eu.horasion.intermediate.superobject.VisitCard.getCardNumber(), public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]
### getDeclaredMethods:
[public java.lang.String eu.horasion.intermediate.superobject.VisitCard.getName(), public boolean eu.horasion.intermediate.superobject.VisitCard.equals(java.lang.Object), protected java.lang.Object eu.horasion.intermediate.superobject.VisitCard.clone() throws java.lang.CloneNotSupportedException, public short eu.horasion.intermediate.superobject.VisitCard.getYearPrinted(), public long eu.horasion.intermediate.superobject.VisitCard.getCardNumber()]
### getSuperclass:
class java.lang.Object
### hashCode visitor1 and visitor2:
1368758648
1368758648

*/
