public void testDescendingIterator() throws Exception {
assertEquals("" + (total - (count + 1)),Bytes.toString(kv.getQualifier()));
assertTrue(Bytes.equals(kv.getValue(),value1));
assertEquals(total,count);
assertEquals("" + (total - (count + 1)),Bytes.toString(kv.getQualifier()));
assertTrue(Bytes.equals(kv.getValue(),value2));
assertEquals(total,count);
}