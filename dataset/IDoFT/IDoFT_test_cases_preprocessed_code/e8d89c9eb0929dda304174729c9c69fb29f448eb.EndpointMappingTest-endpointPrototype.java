@Test public void endpointPrototype() throws Exception {
assertEquals("Invalid request",messageContext,message);
assertNotNull("No endpoint returned",result);
assertNotNull("No endpoint returned",result);
assertEquals("Prototype endpoint was not constructed twice",2,MyEndpoint.constructorCount);//RW
}