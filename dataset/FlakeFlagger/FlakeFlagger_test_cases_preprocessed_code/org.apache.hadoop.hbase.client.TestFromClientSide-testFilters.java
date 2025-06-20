@Test public void testFilters() throws Exception {
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
byte[][] ROWS=makeN(ROW,10);//RW
put.add(FAMILY,QUALIFIERS[i],VALUE);//RW
scan.addFamily(FAMILY);//RW
assertEquals(result.size(),1);
assertTrue(Bytes.equals(result.raw()[0].getRow(),ROWS[expectedIndex]));
assertTrue(Bytes.equals(result.raw()[0].getQualifier(),QUALIFIERS[expectedIndex]));
assertEquals(expectedIndex,6);
}