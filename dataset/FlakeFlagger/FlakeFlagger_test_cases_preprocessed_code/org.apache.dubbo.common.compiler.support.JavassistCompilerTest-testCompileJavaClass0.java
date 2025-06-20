/** 
 * javassist compile will find HelloService in classpath
 */
@Test public void testCompileJavaClass0() throws Exception {
Assert.assertEquals("Hello world!",sayHello.invoke(instance));
}