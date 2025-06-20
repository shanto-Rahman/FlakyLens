@Test public void testCreateWithIncorrectOrder(){
fail("AISMessageFactory didn't throw on incorrect order");
assertEquals("Incorrect order of AIS sentences",iae.getMessage());
fail("Unexpected exception thrown from AISMessageFactory");
}