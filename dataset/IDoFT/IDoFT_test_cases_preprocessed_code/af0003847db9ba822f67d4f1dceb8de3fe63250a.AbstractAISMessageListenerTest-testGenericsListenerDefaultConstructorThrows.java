@Test public void testGenericsListenerDefaultConstructorThrows(){
fail("exception not thrown, resolved to " + gl.messageType);
assertEquals("Cannot resolve generic type <T>, use constructor with Class<T> param.",ise.getMessage());
fail("unexpected exception thrown: " + e.getMessage());
}