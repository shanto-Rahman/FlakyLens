/** 
 * Make sure parent gets cleaned up even if daughter is cleaned up before it.
 */
@Test public void testParentCleanedEvenIfDaughterGoneFirst() throws IOException, InterruptedException {
  parentWithSpecifiedEndKeyCleanedEvenIfDaughterGoneFirst(this.name.getMethodName(),Bytes.toBytes("eee"));
}
