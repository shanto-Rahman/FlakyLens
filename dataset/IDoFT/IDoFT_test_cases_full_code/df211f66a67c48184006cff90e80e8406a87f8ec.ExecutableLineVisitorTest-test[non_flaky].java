@Test public void test() throws Exception {
  String filename="metrics/executable_lines.php";
  PhpFile file=FileTestUtils.getFile(new File("src/test/resources/" + filename));
  Set<Integer> executableLines=new ExecutableLineVisitor(parse(filename)).getExecutableLines();
  assertThat(executableLines).containsOnlyElementsOf(expectedExecutableLines(file));
}
