public void testIncrementColumnValue_UpdatingInPlace() throws IOException {
assertEquals(value + amount,result);
assertEquals(1,store.memstore.kvset.size());
assertTrue(store.memstore.snapshot.isEmpty());
}