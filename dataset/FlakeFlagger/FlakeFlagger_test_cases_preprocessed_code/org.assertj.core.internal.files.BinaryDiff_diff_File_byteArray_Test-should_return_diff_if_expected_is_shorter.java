@Test public void should_return_diff_if_expected_is_shorter() throws IOException {
writer.write(actual,"foobar");//RW
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(3,result.offset);
assertEquals("0x62",result.actual);
assertEquals("EOF",result.expected);
}