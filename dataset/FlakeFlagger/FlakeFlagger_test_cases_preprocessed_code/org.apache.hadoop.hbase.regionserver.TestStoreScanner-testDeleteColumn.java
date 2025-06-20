public void testDeleteColumn() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[3],results.get(0));
}