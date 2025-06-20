/** 
 * Tests cases where rows keys have characters below the ','. See HBASE-832
 * @throws IOException
 */
public void testKeyValueBorderCases() throws IOException {
assertTrue(KeyValue.META_COMPARATOR.compare(rowA,rowB) < 0);
assertTrue(KeyValue.META_COMPARATOR.compare(rowA,rowB) < 0);
assertTrue(KeyValue.ROOT_COMPARATOR.compare(rowA,rowB) < 0);
}