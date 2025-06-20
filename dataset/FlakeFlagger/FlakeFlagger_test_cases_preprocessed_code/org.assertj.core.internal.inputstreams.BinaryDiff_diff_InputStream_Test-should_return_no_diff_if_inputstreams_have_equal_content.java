@Test public void should_return_no_diff_if_inputstreams_have_equal_content() throws IOException {
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertTrue(result.hasNoDiff());
}