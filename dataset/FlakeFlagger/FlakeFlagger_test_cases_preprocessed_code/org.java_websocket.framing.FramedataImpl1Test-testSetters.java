@Test public void testSetters(){
assertEquals("Fin must not be set",false,frame.isFin());
assertEquals("TransferedMask must be set",true,frame.getTransfereMasked());
assertEquals("Payload must be of size 100",100,frame.getPayloadData().capacity());
assertEquals("RSV1 must be true",true,frame.isRSV1());
assertEquals("RSV2 must be true",true,frame.isRSV2());
assertEquals("RSV3 must be true",true,frame.isRSV3());
}