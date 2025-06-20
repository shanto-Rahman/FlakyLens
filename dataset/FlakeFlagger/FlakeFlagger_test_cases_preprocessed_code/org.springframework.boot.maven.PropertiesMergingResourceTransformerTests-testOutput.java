@Test public void testOutput() throws Exception {
assertNotNull(out.toByteArray());
assertTrue(out.toByteArray().length > 0);
}