@Test public void should_return_empty_diff_list_if_inputstreams_have_equal_content() throws IOException {
List<String> diffs=diff.diff(actual,expected);//RW
assertEquals(0,diffs.size());
}