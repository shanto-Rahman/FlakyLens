@Test public void testFailPing() throws Throwable {
if (ex != null) {
assertNotNull("Error message expected",ex.getMessage());
assertTrue(ex.getMessage().contains("Ping attempts failed with errors"));
}
}