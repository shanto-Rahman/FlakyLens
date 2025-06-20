public void testDeleteVersionMaskingMultiplePuts() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs2[1],results.get(0));
}