@Test public void testCreate(){
  AISMessage msg=amf.create(single);
  assertTrue(msg instanceof AISMessage01);
  assertEquals(1,msg.getMessageType());
}
