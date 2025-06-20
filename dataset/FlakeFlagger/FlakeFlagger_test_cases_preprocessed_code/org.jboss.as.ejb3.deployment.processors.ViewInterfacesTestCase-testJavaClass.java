/** 
 * Tests that the    {@link  ViewInterfaces#getPotentialViewInterfaces(Class<?>)}  returns the correctimplementation class for java class implementing MessageListener interface.
 */
@Test public void testJavaClass(){
Assert.assertEquals("One object epected in Java class",1,javaClasses.size());
Assert.assertEquals("Expected interface in Java class",MessageListener.class,javaClasses.iterator().next());
}