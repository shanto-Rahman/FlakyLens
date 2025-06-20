@Test public void testSkipBytes1(){
assertEquals(CAPACITY / 4 * 2,buffer.readerIndex());
fail();
assertEquals(CAPACITY / 4 * 2,buffer.readerIndex());
}