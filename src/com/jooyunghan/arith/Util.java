package com.jooyunghan.arith;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Util {

	@SuppressWarnings("rawtypes")
	public static int sum(List es, String getter) {
		int sum = 0;
		for (Object o : map(es, getter))
			sum += (Integer) o;
		return sum;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int max(List es, String getter) {
		return Collections.max(map(es, getter));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Collection map(List es, String getter) {
		List result = new ArrayList();
		for (Object o : es) {
			try {
				Method m = o.getClass().getMethod(getter);
				result.add(m.invoke(o));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
