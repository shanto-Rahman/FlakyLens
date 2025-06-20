@Test public void should_return_empty_diff_list_if_files_have_equal_content() throws IOException {
writer.write(actual,content);//RW
writer.write(expected,content);//RW
List<String> diffs=diff.diff(actual,expected);//RW
assertEquals(0,diffs.size());
}