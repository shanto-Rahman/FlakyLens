@Test public void getPathTest() throws IOException {
Assert.assertEquals("/x/table" + k,table.getPath());
Assert.assertEquals("/x/table" + k,table.getPath());
Assert.assertEquals("/y/tab" + k,table.getPath());
Assert.assertEquals("/y/tab" + k,table.getPath());
}