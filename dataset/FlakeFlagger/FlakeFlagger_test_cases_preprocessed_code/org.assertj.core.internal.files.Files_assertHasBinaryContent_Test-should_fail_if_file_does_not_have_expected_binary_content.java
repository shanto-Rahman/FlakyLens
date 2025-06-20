@Test public void should_fail_if_file_does_not_have_expected_binary_content() throws IOException {
when(binaryDiff.diff(actual,expected)).thenReturn(diff);//RW
files.assertHasBinaryContent(info,actual,expected);//RW
verify(failures).failure(info,shouldHaveBinaryContent(actual,diff));//RW
}