package cl;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileClassLoaderDefineClassWithEverytimeTest {
	FileClassLoaderDefineClassWithEverytime loader;
	String pathA = "resource\\classA\\C.class";
	String pathB = "resource\\classB\\C.class";
	@Test
	public void testLoadClassWithOnce() throws Exception {
		loader = new FileClassLoaderDefineClassWithEverytime();
		loader.SetPath(pathA);
		SayHi sayA = (SayHi) loader.loadClass("cl.C").newInstance();
		
		assertEquals("A", sayA.say());
	}

	@Test
	public void testLoadClassWithMulti() throws Exception{
		loader = new FileClassLoaderDefineClassWithEverytime();
		loader.SetPath(pathA);
		SayHi sayA = (SayHi) loader.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		

		sayA = (SayHi) loader.loadClass("cl.C").newInstance();	//�������¶���ָ���࣬����
		assertEquals("A", sayA.say());
	}
	
	@Test
	public void testLoadClassWithMultiPath() throws Exception{
		loader = new FileClassLoaderDefineClassWithEverytime();
		loader.SetPath(pathA);
		SayHi sayA = (SayHi) loader.loadClass("cl.C").newInstance();
		assertEquals("A", sayA.say());
		
		loader.SetPath(pathB); //���Ի���·��������
		sayA = (SayHi) loader.loadClass("cl.C").newInstance();	//�������¶���ָ���࣬����
		assertEquals("A", sayA.say());
	}
}
