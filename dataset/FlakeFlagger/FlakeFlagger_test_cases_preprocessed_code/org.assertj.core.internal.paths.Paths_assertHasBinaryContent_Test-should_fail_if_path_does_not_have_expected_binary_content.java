@Test public void should_fail_if_path_does_not_have_expected_binary_content() throws IOException {
when(binaryDiff.diff(path.toFile(),expected)).thenReturn(binaryDiffs);//RW
when(nioFilesWrapper.exists(path)).thenReturn(true);//RW
when(nioFilesWrapper.isReadable(path)).thenReturn(true);//RW
paths.assertHasBinaryContent(info,path,expected);//RW
verify(failures).failure(info,shouldHaveBinaryContent(path.toFile(),binaryDiffs));//RW
}