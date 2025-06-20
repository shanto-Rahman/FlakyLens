public void testMultipleVersionsSimple() throws Exception {
assertTrue("Expected memstore to hold 3 values, actually has " + m.kvset.size(),m.kvset.size() == 3);
}