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
		loaderB = loaderA; //��loaderA������ͬ��ʵ����
	
		loaderA.SetPath(pathA);
		SayHi sayA = (SayHi)loaderA.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		
		
		loaderB.SetPath(pathB);
		SayHi sayB = (SayHi)loaderB.loadClass("cl.C").newInstance();//���Դ��µ�λ�ü�����C
		assertEquals("A", sayB.say());	//���ط��ص��ಢû�б仯��
	}
	
	@Test
	public void testMultiLoaderInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		loaderA = new FileClassLoader();
		loaderB = new FileClassLoader(); //��loaderA���ò�ͬ��ʵ����
	
		loaderA.SetPath(pathA);
		SayHi sayA = (SayHi)loaderA.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		
		
		loaderB.SetPath(pathB);
		SayHi sayB = (SayHi)loaderB.loadClass("cl.C").newInstance();//���Դ��µ�λ�ü�����C
		assertEquals("B", sayB.say());	//���ص������µ��ࡣ
	
		
	}

}
