@Test public void should_return_diff_if_actual_is_shorter() throws IOException {
writer.write(actual,"foo");//RW
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertEquals(3 + LINE_SEPARATOR.length(),result.offset);
assertEquals("EOF",result.actual);
assertEquals("0x62",result.expected);
}