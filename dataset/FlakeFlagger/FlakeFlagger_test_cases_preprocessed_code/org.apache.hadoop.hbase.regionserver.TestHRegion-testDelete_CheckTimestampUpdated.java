public void testDelete_CheckTimestampUpdated() throws IOException {
assertTrue(firstKv.getTimestamp() <= now);
assertTrue(kv.getTimestamp() <= now);
}