@Test public void testWriteGrpahWithMultipleEdges() throws IOException {
  String[] edges={"A,B","C,D"};
  writeToGraph(edges);
  lines=Files.readAllLines(path,charset);
  assertTrue(lines.contains("A B"));
  assertTrue(lines.contains("C D"));
  assertEquals(2,lines.size());
}
