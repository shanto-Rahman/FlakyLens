public void testKeepDeleteInmemstore(){
assertEquals(1,memstore.kvset.size());
assertEquals(delete,memstore.kvset.first());
}