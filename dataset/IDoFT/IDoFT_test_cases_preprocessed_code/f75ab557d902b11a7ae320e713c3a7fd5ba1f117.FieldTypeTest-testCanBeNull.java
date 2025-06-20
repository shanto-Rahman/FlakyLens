@Test public void testCanBeNull() throws Exception {
assertTrue(fields.length >= 2);
assertTrue(fieldType.isCanBeNull());
assertFalse(fieldType.isCanBeNull());
}