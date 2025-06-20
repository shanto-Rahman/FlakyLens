public void testScanner() throws IOException {
assertNotNull(results);
assertEquals(1,results.length);
assertTrue(Bytes.equals(ROW_1,results[0].getRow()));
assertNotNull(results);
assertEquals(3,results.length);
assertTrue(Bytes.equals(ROW_2,results[0].getRow()));
assertTrue(Bytes.equals(ROW_3,results[1].getRow()));
assertTrue(Bytes.equals(ROW_4,results[2].getRow()));
assertNull(results);
}