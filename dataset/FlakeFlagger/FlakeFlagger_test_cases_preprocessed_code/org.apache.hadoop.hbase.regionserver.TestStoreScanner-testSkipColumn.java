public void testSkipColumn() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(2,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(kvs[3],results.get(1));
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[kvs.length - 1],results.get(0));
assertEquals(false,scan.next(results));
}