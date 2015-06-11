package cl;

import static org.junit.Assert.*;



//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

public class FileClassLoaderTest {
	FileClassLoader loaderA;
	FileClassLoader loaderB;
	String pathA = "resource\\classA\\C.class";
	String pathB = "resource\\classB\\C.class";
	

	@Test
	public void testOnlyOneLoaderInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		loaderA = new FileClassLoader();
		loaderB = loaderA; //与loaderA引用相同的实例。
	
		loaderA.SetPath(pathA);
		SayHi sayA = (SayHi)loaderA.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		
		
		loaderB.SetPath(pathB);
		SayHi sayB = (SayHi)loaderB.loadClass("cl.C").newInstance();//尝试从新的位置加载类C
		assertEquals("A", sayB.say());	//加载返回的类并没有变化。
	}
	
	@Test
	public void testMultiLoaderInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		loaderA = new FileClassLoader();
		loaderB = new FileClassLoader(); //与loaderA引用不同的实例。
	
		loaderA.SetPath(pathA);
		SayHi sayA = (SayHi)loaderA.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		
		
		loaderB.SetPath(pathB);
		SayHi sayB = (SayHi)loaderB.loadClass("cl.C").newInstance();//尝试从新的位置加载类C
		assertEquals("B", sayB.say());	//加载的类是新的类。
	
		
	}

}
