@Test public void createRawTableTestEmptyMetadata() throws IOException {
Assert.assertEquals(fileId,table.getId());
Assert.assertEquals("/tables/table1",table.getPath());
Assert.assertEquals(20,table.getColumns());
Assert.assertEquals(ByteBuffer.allocate(0),table.getMetadata());
Assert.assertEquals(fileId,table.getId());
Assert.assertEquals("/tables/table1",table.getPath());
Assert.assertEquals(20,table.getColumns());
Assert.assertEquals(ByteBuffer.allocate(0),table.getMetadata());
}