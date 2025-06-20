public void testDeleteFamiliy() throws IOException {
assertTrue(scan.next(results));
assertEquals(11,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(kvs[1],results.get(1));
assertEquals(kvs[2],results.get(2));
assertEquals(kvs[3],results.get(3));
assertEquals(kvs[5],results.get(4));
assertEquals(kvs[4],results.get(5));
assertEquals(kvs[6],results.get(6));
assertEquals(kvs[8],results.get(7));
assertEquals(kvs[7],results.get(8));
assertEquals(kvs[9],results.get(9));
assertEquals(kvs[10],results.get(10));
assertFalse(scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[kvs.length - 1],results.get(0));
}