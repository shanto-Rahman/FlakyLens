public void testIterator() throws Exception {
assertEquals("" + count,Bytes.toString(kv.getQualifier()));
assertTrue(Bytes.equals(kv.getValue(),value1));
assertEquals(total,count);
assertEquals("" + count,Bytes.toString(kv.getQualifier()));
assertTrue(Bytes.equals(kv.getValue(),value2));
assertEquals(total,count);
}