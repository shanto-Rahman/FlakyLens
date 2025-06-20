/** 
 * This should cause the jar file to be sent to the other side
 */
public void testJarLoadingTest() throws Exception {
  channel.call(new ForceJarLoad(sum1));
  channel.call(new ForceJarLoad(sum2));
  Callable<Void,IOException> sc=(Callable<Void,IOException>)cl.loadClass("test.ClassLoadingFromJarTester").newInstance();
  ((Function<Function<Object,Object>,Void>)sc).apply(new Verifier());
  assertNull(channel.call(sc));
}
