public void testWideScanBatching() throws IOException {
assertTrue(results.size() <= BATCH);
if (results.size() > 0) {
assertTrue(Bytes.equals(row,kv.getRow()));
}
assertTrue(total == inserted);
}