/** 
 * Checks if the HeapSize calculator is within reason
 */
@SuppressWarnings("unchecked") public void testHeapSizeForBlockIndex() throws IOException {
if (expected != actual) {
assertEquals(expected,actual);
}
}