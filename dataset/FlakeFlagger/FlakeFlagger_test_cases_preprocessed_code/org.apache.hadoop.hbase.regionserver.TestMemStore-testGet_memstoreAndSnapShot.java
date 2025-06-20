public void testGet_memstoreAndSnapShot() throws IOException {
assertEquals(3,memstore.snapshot.size());
assertEquals(0,memstore.kvset.size());
assertEquals(2,memstore.kvset.size());
assertEquals(true,res);
}