public void testAdd() throws Exception {
assertTrue(this.kvsls.contains(kv));
assertEquals(1,this.kvsls.size());
assertTrue(kv.equals(first));
assertTrue(Bytes.equals(kv.getValue(),first.getValue()));
assertEquals(1,this.kvsls.size());
assertTrue(Bytes.equals(overwrite.getValue(),first.getValue()));
assertFalse(Bytes.equals(overwrite.getValue(),kv.getValue()));
}