public void testDelete() throws IOException {
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNotNull(value2);
assertTrue(Bytes.equals(VALUE_2,value2));
assertNotNull(value1);
assertTrue(Bytes.equals(VALUE_1,value1));
assertNull(value2);
assertNull(value1);
assertNull(value2);
}