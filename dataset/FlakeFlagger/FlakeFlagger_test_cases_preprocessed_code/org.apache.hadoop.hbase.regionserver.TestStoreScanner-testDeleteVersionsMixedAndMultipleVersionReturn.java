public void testDeleteVersionsMixedAndMultipleVersionReturn() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(2,results.size());
assertEquals(kvs2[1],results.get(0));
assertEquals(kvs2[0],results.get(1));
}