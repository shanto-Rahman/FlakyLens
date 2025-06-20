@Test public void testGetClosestRowBefore() throws IOException {
assertTrue(result == null);
assertTrue(result.containsColumn(HConstants.CATALOG_FAMILY,null));
assertTrue(Bytes.equals(result.getValue(HConstants.CATALOG_FAMILY,null),zero));
assertTrue(result.containsColumn(HConstants.CATALOG_FAMILY,null));
assertTrue(Bytes.equals(result.getValue(HConstants.CATALOG_FAMILY,null),zero));
assertTrue(result.containsColumn(HConstants.CATALOG_FAMILY,null));
assertTrue(Bytes.equals(result.getValue(HConstants.CATALOG_FAMILY,null),one));
assertTrue(result.containsColumn(HConstants.CATALOG_FAMILY,null));
assertTrue(Bytes.equals(result.getValue(HConstants.CATALOG_FAMILY,null),one));
}