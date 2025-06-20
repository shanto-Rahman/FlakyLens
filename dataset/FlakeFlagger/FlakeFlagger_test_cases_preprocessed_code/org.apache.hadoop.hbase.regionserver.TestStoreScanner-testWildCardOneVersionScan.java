public void testWildCardOneVersionScan() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(2,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(kvs[1],results.get(1));
}