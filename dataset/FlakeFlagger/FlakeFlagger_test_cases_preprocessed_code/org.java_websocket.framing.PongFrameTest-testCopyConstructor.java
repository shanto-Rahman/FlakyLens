@Test public void testCopyConstructor(){
assertEquals("Payload must be equal",pingFrame.getPayloadData(),pongFrame.getPayloadData());
}