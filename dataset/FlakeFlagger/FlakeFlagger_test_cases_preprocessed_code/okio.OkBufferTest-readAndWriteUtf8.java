@Test public void readAndWriteUtf8() throws Exception {
assertEquals(2,buffer.size());
assertEquals(6,buffer.size());
assertEquals("abcd",buffer.readUtf8(4));
assertEquals(2,buffer.size());
assertEquals("ef",buffer.readUtf8(2));
assertEquals(0,buffer.size());
fail();
}