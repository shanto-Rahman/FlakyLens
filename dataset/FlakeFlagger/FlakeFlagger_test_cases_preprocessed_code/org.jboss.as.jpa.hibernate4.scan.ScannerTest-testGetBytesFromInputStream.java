@Test public void testGetBytesFromInputStream() throws Exception {
InputStream stream=new BufferedInputStream(new FileInputStream(file));
stream=new BufferedInputStream(new FileInputStream(file));
assertEquals(oldLength,newLength);
assertTrue(oldTime > newTime);
}