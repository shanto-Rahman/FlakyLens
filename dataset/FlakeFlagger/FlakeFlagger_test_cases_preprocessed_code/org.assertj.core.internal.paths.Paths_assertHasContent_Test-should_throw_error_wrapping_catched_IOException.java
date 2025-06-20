@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
when(diff.diff(path.toFile(),expected,charset)).thenThrow(cause);//RW
when(nioFilesWrapper.exists(path)).thenReturn(true);//RW
when(nioFilesWrapper.isReadable(path)).thenReturn(true);//RW
paths.assertHasContent(someInfo(),path,expected,charset);//RW
assertThat(e.getCause()).isSameAs(cause);
}