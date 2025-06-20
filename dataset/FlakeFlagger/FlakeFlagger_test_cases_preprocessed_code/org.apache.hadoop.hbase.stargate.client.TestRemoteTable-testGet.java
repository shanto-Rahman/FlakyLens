public void testGet() throws IOException {
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNull(value2);
assertNull(value1);
assertNull(value2);
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNull(value2);
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_2,value1));
assertNotNull(value2);
assertTrue(Bytes.equals(VALUE_2,value2));
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_2,value1));
assertNull(value2);
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_2,value1));
assertNotNull(value2);
assertTrue(Bytes.equals(VALUE_2,value2));
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNull(value2);
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNull(value2);
if (Bytes.equals(COLUMN_1,kv.getFamily()) && TS_1 == kv.getTimestamp()) {
assertTrue(Bytes.equals(VALUE_1,kv.getValue()));
}
if (Bytes.equals(COLUMN_1,kv.getFamily()) && TS_2 == kv.getTimestamp()) {
assertTrue(Bytes.equals(VALUE_2,kv.getValue()));
}
assertEquals(2,count);
}