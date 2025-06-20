public void testScanTimeRange() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(5,results.size());
assertEquals(kvs[kvs.length - 1],results.get(0));
assertEquals(true,scan.next(results));
assertEquals(2,results.size());
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(true,scan.next(results));
assertEquals(3,results.size());
}