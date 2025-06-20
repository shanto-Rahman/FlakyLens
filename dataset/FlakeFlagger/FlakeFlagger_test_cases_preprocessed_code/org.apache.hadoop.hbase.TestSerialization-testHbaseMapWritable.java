@SuppressWarnings("unchecked") public void testHbaseMapWritable() throws Exception {
assertTrue(hmw.size() == 1);
assertTrue(Bytes.equals("value".getBytes(),hmw.get("key".getBytes())));
}