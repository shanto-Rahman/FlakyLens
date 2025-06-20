public void testDeleteVersionSameTimestamp() throws IOException {
assertFalse(scan.next(results));
assertEquals(0,results.size());
}