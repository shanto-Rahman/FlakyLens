public void testGetWithDeleteColumn() throws IOException {
assertEquals(3,memstore.kvset.size());
assertEquals(2,memstore.kvset.size());
assertEquals(expected.get(i++),kv);
}