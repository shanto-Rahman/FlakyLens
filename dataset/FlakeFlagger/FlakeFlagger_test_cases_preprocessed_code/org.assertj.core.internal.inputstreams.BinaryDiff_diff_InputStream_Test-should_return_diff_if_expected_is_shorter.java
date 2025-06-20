@Test public void should_return_diff_if_expected_is_shorter() throws IOException {
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(3,result.offset);
assertEquals("0xBE",result.actual);
assertEquals("EOF",result.expected);
}