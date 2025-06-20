@Test public void should_fail_if_files_do_not_have_equal_content() throws IOException {
when(diff.diff(actual,expected)).thenReturn(diffs);//RW
files.assertSameContentAs(info,actual,expected);//RW
verify(failures).failure(info,ShouldHaveSameContent.shouldHaveSameContent(actual,expected,diffs));//RW
}