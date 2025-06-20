@SuppressWarnings("unchecked") @Test public void includedDeltas() throws Exception {
assertTrue(includes.contains("templates/**"));
assertFalse(includes.contains("static/**"));
}