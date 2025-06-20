@Test public void should_return_diff_if_actual_is_shorter() throws IOException {
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(3,result.offset);
assertEquals("EOF",result.actual);
assertEquals("0xBE",result.expected);
}