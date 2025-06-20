@Test public void should_fail_if_file_does_not_have_expected_text_content() throws IOException {
when(diff.diff(actual,expected,charset)).thenReturn(diffs);//RW
files.assertHasContent(info,actual,expected,charset);//RW
verify(failures).failure(info,shouldHaveContent(actual,charset,diffs));//RW
}