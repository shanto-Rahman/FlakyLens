public void testIncrementColumnValue_ICVDuringFlush() throws IOException {
assertTrue(ret > 0);
assertEquals(1,this.store.getStorefiles().size());
assertEquals(2,this.store.memstore.kvset.size());
assertEquals(2,results.size());
assertTrue(ts1 > ts2);
assertEquals(newValue,Bytes.toLong(results.get(0).getValue()));
assertEquals(oldValue,Bytes.toLong(results.get(1).getValue()));
}