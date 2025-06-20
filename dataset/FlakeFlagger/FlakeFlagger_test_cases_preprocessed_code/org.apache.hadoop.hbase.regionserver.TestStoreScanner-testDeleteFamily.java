public void testDeleteFamily() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(0,results.size());
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[kvs.length - 1],results.get(0));
assertEquals(false,scan.next(results));
}