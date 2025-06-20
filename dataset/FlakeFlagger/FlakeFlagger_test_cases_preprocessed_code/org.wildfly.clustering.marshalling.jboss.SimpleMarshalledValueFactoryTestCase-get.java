/** 
 * Test method for  {@link org.jboss.ha.framework.server.SimpleMarshalledValue#get()}.
 */
@Test public void get() throws Exception {
assertNotNull(mv.peek());
assertSame(uuid,mv.peek());
assertSame(uuid,mv.get(this.context));
assertNull(copy.peek());
assertNotSame(uuid,uuid2);
assertEquals(uuid,uuid2);
assertEquals(uuid,uuid2);
assertNull(mv.peek());
assertNull(mv.getBytes());
assertNull(mv.get(this.context));
}