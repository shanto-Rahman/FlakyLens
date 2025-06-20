@Test public void should_return_no_diff_if_file_and_array_have_equal_content() throws IOException {
writer.write(actual,"test");//RW
BinaryDiffResult result=binaryDiff.diff(actual,expected);//RW
assertTrue(result.hasNoDiff());
}