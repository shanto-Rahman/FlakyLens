@Test public void should_return_empty_diff_list_if_file_and_string_have_equal_content() throws IOException {
writer.write(actual,content);//RW
List<String> diffs=diff.diff(actual,expected,Charset.defaultCharset());//RW
assertEquals(0,diffs.size());
}