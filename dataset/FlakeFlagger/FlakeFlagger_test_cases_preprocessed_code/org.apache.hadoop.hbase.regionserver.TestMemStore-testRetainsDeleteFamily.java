public void testRetainsDeleteFamily() throws IOException {
assertEquals(1,memstore.kvset.size());
assertEquals(delete,memstore.kvset.first());
}