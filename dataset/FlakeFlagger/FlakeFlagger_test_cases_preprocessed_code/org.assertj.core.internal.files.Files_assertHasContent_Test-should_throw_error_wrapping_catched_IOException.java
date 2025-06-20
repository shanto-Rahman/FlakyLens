@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
when(diff.diff(actual,expected,charset)).thenThrow(cause);//RW
files.assertHasContent(someInfo(),actual,expected,charset);//RW
fail("Expected a FilesException to be thrown");
assertSame(cause,e.getCause());
}