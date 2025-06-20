/** 
 * Test method for  {@link org.jboss.ha.framework.server.SimpleMarshalledValue#hashCode()}.
 */
@Test public void testHashCode() throws Exception {
assertEquals(uuid.hashCode(),mv.hashCode());
assertEquals(0,mv.hashCode());
}