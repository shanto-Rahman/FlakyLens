@Test public void should_fail_if_path_does_not_have_expected_text_content() throws IOException {
when(diff.diff(path.toFile(),expected,charset)).thenReturn(diffs);//RW
when(nioFilesWrapper.exists(path)).thenReturn(true);//RW
when(nioFilesWrapper.isReadable(path)).thenReturn(true);//RW
paths.assertHasContent(info,path,expected,charset);//RW
verify(failures).failure(info,shouldHaveContent(path.toFile(),charset,diffs));//RW
}