@Test public void testAppend(){
assertEquals("Fin must be set",true,frame0.isFin());
assertArrayEquals("Payload must be equal","firstsecond".getBytes(),frame0.getPayloadData().array());
}