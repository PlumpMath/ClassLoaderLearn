package cl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileClassLoaderDefineClassWithEverytime extends ClassLoader{
	String path ;
	public void SetPath(String path){
		this.path = path;
	}
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if("cl.C".equals(name)){
			return this.findClass(name);	//尝试每次加载类cl.C时都重新定义。
		}
		return super.loadClass(name);
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream(path)){
			byte classbyte [] = new byte[fis.available()];
			for(int i=0; i<classbyte.length; i++){
				classbyte[i] = (byte) fis.read();
			}
			
			return this.defineClass(name, classbyte, 0, classbyte.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ClassNotFoundException("文件没找到", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ClassNotFoundException("IO异常", e);
		}
	}
}
