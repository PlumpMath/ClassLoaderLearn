#了解和使用ClassLoader
## 使用
 - 简单使用classLoader只需要继承java.lang.ClassLoader类，并实现其findClass方法。

## 结论
 - 一个ClassLoader实例对一个类只能加载一次。
 - 如果尝试重写ClassLoader的loadClass方法并在每次加载类的时候重新定义类，会发生异常。
 - 使用不同的类加载器实例可以加载同一个类名的不同实现，并且被实例化的类会在程序中表现出不同的行为。
