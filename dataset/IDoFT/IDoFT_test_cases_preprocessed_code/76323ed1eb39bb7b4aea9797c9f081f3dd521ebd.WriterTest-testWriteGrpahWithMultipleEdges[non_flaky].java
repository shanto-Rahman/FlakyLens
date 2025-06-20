@Test public void testWriteGrpahWithMultipleEdges() throws IOException {
lines=Files.readAllLines(path,charset);//RW
assertTrue(lines.contains("A B"));//RW
assertTrue(lines.contains("C D"));//RW
assertEquals(2,lines.size());//RW
}