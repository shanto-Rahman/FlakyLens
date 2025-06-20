@Test public void testListTables() throws IOException {
TEST_UTIL.createTable(tables[i],FAMILY);//RW
assertTrue(size >= tables.length);
if (Bytes.equals(ts[j].getName(),tables[i])) {
}
assertTrue("Not found: " + Bytes.toString(tables[i]),found);
}