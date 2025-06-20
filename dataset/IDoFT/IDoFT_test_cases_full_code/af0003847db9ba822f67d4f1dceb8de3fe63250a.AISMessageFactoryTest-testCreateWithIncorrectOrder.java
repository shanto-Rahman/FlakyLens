@Test public void testCreateWithIncorrectOrder(){
  try {
    amf.create(split2,split1);
    fail("AISMessageFactory didn't throw on incorrect order");
  }
 catch (  IllegalArgumentException iae) {
    assertEquals("Incorrect order of AIS sentences",iae.getMessage());
  }
catch (  Exception e) {
    fail("Unexpected exception thrown from AISMessageFactory");
  }
}
