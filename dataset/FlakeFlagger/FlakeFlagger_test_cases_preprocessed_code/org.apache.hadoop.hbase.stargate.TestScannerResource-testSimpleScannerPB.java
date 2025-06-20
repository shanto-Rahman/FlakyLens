public void testSimpleScannerPB() throws IOException {
assertEquals(response.getCode(),201);
assertNotNull(scannerURI);
assertEquals(response.getCode(),200);
assertEquals(countCellSet(cellSet),BATCH_SIZE);
assertEquals(response.getCode(),200);
}