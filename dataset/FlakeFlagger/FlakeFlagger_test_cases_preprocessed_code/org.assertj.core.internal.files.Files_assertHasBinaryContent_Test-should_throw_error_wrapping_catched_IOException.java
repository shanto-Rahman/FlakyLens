@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
when(binaryDiff.diff(actual,expected)).thenThrow(cause);//RW
files.assertHasBinaryContent(someInfo(),actual,expected);//RW
fail("Expected a FilesException to be thrown");
assertSame(cause,e.getCause());
}