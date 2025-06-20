@Test public void testLogCleaning() throws Exception {
assertEquals(34,fs.listStatus(oldLogDir).length);
assertEquals(14,fs.listStatus(oldLogDir).length);
assertEquals(1,fs.listStatus(oldLogDir).length);
}