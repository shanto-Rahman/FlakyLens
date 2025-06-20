public void testSingleCellGetPutBinary() throws IOException {
assertEquals(response.getCode(),200);
Thread.yield();
assertEquals(response.getCode(),200);
assertTrue(Bytes.equals(response.getBody(),body));
if (header.getName().equals("X-Timestamp")) {
}
assertTrue(foundTimestampHeader);
assertEquals(response.getCode(),200);
}