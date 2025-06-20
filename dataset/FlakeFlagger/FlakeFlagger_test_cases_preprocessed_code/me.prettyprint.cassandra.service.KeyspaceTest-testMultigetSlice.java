@Test public void testMultigetSlice() throws HectorException {
assertNotNull(cl);
assertEquals(1,cl.size());
assertTrue(string(cl.get(0).getValue()).startsWith("testMultigetSlice_"));
}