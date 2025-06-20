public void testRetainsDeleteVersion() throws IOException {
assertEquals(1,memstore.kvset.size());
assertEquals(delete,memstore.kvset.first());
}