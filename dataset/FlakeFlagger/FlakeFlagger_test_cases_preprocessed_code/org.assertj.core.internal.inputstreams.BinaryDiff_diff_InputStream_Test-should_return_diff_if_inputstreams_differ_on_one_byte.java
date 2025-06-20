@Test public void should_return_diff_if_inputstreams_differ_on_one_byte() throws IOException {
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(2,result.offset);
assertEquals("0xBA",result.actual);
assertEquals("0xBE",result.expected);
}