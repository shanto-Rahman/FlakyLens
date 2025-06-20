public void testIncrementColumnValue_UpdatingFromSF() throws IOException {
assertEquals(0,store.memstore.kvset.size());
assertEquals(value + amount,r);
}