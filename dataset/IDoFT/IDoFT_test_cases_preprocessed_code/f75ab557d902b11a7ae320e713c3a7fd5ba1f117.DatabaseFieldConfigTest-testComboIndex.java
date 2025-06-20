@Test public void testComboIndex() throws Exception {
assertTrue(fields.length >= 2);
assertEquals(ComboIndex.INDEX_NAME,fieldConfig.getIndexName(tableName));
assertEquals(ComboIndex.INDEX_NAME,fieldConfig.getIndexName(tableName));
}