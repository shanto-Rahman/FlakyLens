@Test public void testBadRequest() throws Throwable {
if (ex != null) {
assertNotNull("Error message expected",ex.getMessage());
assertTrue(ex instanceof IllegalArgumentException);
}
}