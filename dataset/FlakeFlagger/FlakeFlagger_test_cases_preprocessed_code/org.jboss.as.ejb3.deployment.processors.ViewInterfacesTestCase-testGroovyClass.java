/** 
 * Tests that the    {@link  ViewInterfaces#getPotentialViewInterfaces(Class<?>)}  returns the correctimplementation class for groovy class implementing MessageListener interface.
 */
@Test public void testGroovyClass(){
Assert.assertEquals("One object epected in Groovy class",1,groovyClasses.size());
Assert.assertEquals("Expected interface in Groovy class",MessageListener.class,groovyClasses.iterator().next());
}