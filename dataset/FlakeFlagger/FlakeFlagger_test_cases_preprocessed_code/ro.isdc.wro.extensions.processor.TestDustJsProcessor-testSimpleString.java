@Test public void testSimpleString() throws Exception {
assertTrue(result.matches("\\(function\\(\\)\\{.*\\}\\)\\(\\);"));
}