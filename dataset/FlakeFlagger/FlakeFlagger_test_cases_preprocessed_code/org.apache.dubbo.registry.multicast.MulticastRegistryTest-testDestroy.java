/** 
 * Test method for  {@link MulticastRegistry#destroy()}
 */
@Test public void testDestroy(){
assertFalse(socket.isClosed());
assertTrue(socket.isClosed());
}