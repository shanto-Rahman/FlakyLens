@Test public void testWriteGrpahWithMultipleEdges() throws IOException {
lines=Files.readAllLines(path,charset);//RW
String line=lines.get(0);//RW
assertEquals("A B",line);
line=lines.get(1);//RW
assertEquals("C D",line);
assertEquals(2,lines.size());//RW
}