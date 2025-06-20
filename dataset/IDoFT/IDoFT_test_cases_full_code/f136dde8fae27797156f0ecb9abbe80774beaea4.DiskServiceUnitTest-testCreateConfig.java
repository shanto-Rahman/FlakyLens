@Test public void testCreateConfig() throws IOException {
  DiskUtil.saveToDisk("testDataId","testGroup","testTenant","testContent");
  String content=DiskUtil.getConfig("testDataId","testGroup","testTenant");
  assertEquals(content,"testContent");
}
