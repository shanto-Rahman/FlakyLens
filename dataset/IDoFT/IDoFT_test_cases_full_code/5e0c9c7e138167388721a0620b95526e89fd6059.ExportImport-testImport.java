@Test public void testImport() throws Exception {
  URL url=getClass().getResource("/rrdtool/0003l648.rrd");
  String imported=testFolder.getRoot().getAbsolutePath() + "/testexport.rrd";
  RrdDb.getBuilder().setPath(imported).setRrdToolImporter(url.getFile()).doimport();
  try (RrdDb db=RrdDb.getBuilder().setPath(imported).readOnly().setBackendFactory(new RrdNioBackendFactory()).build()){
    Assert.assertNotNull(db.getDatasource("speed"));
    Assert.assertNotNull(db.getDatasource("weight"));
  }
 }
