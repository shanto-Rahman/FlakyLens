@Test public void testUnsupportedRegistryVersion() throws Throwable {
if (ex != null) {
assertNotNull("Error message expected",ex.getMessage());
assertTrue(ex.getMessage().contains("Unsupported registry version"));
}
if (ex != null) {
assertNotNull("Error message expected",ex.getMessage());
assertTrue(ex.getMessage().contains("Unsupported registry version"));
}
}