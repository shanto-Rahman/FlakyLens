public void testScanSameTimestamp() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[0],results.get(0));
}