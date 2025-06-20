public void testSimpleScannerBinary() throws IOException {
assertEquals(response.getCode(),201);
assertNotNull(scannerURI);
assertEquals(response.getCode(),200);
assertTrue(response.getBody().length > 0);
if (header.getName().equals("X-Row")) {
if (header.getName().equals("X-Column")) {
if (header.getName().equals("X-Timestamp")) {
}
}
}
assertTrue(foundRowHeader);
assertTrue(foundColumnHeader);
assertTrue(foundTimestampHeader);
assertEquals(response.getCode(),200);
}