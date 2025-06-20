@Test public void should_pass_if_path_has_expected_text_content() throws IOException {
when(binaryDiff.diff(path.toFile(),expected)).thenReturn(noDiff());//RW
when(nioFilesWrapper.exists(path)).thenReturn(true);//RW
when(nioFilesWrapper.isReadable(path)).thenReturn(true);//RW
paths.assertHasBinaryContent(someInfo(),path,expected);//RW
}