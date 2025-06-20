public void testDeleteVersion() throws IOException {
assertFalse(scan.next(results));
assertEquals(3,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(kvs[1],results.get(1));
assertEquals(kvs[2],results.get(2));
}