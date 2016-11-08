package ua.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionRunner {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		
		
		View view = new View();
		Date dt1 = new Date(1,1,2016);
		Date dt2 = new Date();
		dt1.setDay(2);
		dt2.setDate(1,dt1.getMonth(), dt1.getYear());
		view.print(dt1.getDay()+"");
		view.print(dt2.getDay()+"");
		Class clazz = Class.forName("ua.training.RecordBook");
		Object instance = (RecordBook) clazz.newInstance();

		for (Constructor c : clazz.getDeclaredConstructors()) {
			view.print(c.getName());

		}
		int m = clazz.getModifiers();
		if (Modifier.isPublic(m)) {
			view.print("public");
		}
		if (Modifier.isAbstract(m)) {
			view.print("abstract");
		}
		if (Modifier.isFinal(m)) {
			view.print("final");
		}

		for (Method method : clazz.getMethods()) {
			MyAnnotation cool = method.getAnnotation(MyAnnotation.class);
			if (cool != null && cool.enabled()) {
				view.print("Call by " + MyAnnotation.class.getName() + " " + method.invoke(instance));
			}
		}

		Class clazz2 = Class.forName("ua.training.Date");
		Object instance2 = (Date) clazz.newInstance();

		for (Constructor c : clazz2.getDeclaredConstructors()) {
			view.print(c.getName());

		}

		for (Method method : clazz2.getMethods()) {
			MyAnnotation cool = method.getAnnotation(MyAnnotation.class);
			if (cool != null && cool.enabled()) {
				view.print("Call by " + MyAnnotation.class.getName() + " " + method.invoke(instance));
			}
		}
		int m2 = clazz2.getModifiers();
		if (Modifier.isPublic(m2)) {
			view.print("public");
		}

	}
}
