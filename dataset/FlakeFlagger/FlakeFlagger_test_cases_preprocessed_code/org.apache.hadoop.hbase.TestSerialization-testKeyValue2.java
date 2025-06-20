public void testKeyValue2() throws Exception {
assertTrue(Bytes.equals(kv.getBuffer(),deserializedKv.getBuffer()));
assertEquals(kv.getOffset(),deserializedKv.getOffset());
assertEquals(kv.getLength(),deserializedKv.getLength());
}