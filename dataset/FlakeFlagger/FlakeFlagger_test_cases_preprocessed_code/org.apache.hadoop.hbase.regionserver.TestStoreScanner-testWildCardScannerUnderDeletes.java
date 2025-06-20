public void testWildCardScannerUnderDeletes() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(5,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(kvs[2],results.get(1));
assertEquals(kvs[3],results.get(2));
assertEquals(kvs[6],results.get(3));
assertEquals(kvs[7],results.get(4));
}