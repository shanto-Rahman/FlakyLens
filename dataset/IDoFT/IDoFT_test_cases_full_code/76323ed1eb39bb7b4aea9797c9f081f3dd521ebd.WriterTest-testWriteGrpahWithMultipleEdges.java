@Test public void testWriteGrpahWithMultipleEdges() throws IOException {
  String[] edges={"A,B","C,D"};
  writeToGraph(edges);
  lines=Files.readAllLines(path,charset);
  String line=lines.get(0);
  assertEquals("A B",line);
  line=lines.get(1);
  assertEquals("C D",line);
  assertEquals(2,lines.size());
}
