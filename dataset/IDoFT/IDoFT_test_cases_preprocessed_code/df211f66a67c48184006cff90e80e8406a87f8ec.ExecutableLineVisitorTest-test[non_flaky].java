@Test public void test() throws Exception {
PhpFile file=FileTestUtils.getFile(new File("src/test/resources/" + filename));//RO
assertThat(executableLines).containsOnlyElementsOf(expectedExecutableLines(file));
}