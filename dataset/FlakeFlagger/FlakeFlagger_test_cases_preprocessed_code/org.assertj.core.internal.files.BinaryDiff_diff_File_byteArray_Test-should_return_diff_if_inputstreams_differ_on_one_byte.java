@Test public void should_return_diff_if_inputstreams_differ_on_one_byte() throws IOException {
writer.write(actual,"test");//RW
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(0,result.offset);
assertEquals("0x74",result.actual);
assertEquals("0x66",result.expected);
}