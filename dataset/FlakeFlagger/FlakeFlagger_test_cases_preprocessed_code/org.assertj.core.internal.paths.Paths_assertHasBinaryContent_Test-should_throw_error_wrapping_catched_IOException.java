@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
when(binaryDiff.diff(path.toFile(),expected)).thenThrow(cause);//RW
when(nioFilesWrapper.exists(path)).thenReturn(true);//RW
when(nioFilesWrapper.isReadable(path)).thenReturn(true);//RW
paths.assertHasBinaryContent(someInfo(),path,expected);//RW
assertThat(e.getCause()).isSameAs(cause);
}