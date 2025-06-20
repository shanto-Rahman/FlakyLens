@Test public void testConstructor(){
  BasicListener bl=new BasicListener();
  assertNull(bl.received);
  assertEquals(bl.messageType,AISMessage01.class);
}
