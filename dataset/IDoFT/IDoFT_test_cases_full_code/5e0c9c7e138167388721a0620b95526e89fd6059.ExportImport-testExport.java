@Test public void testExport() throws Exception {
  File rrdXmlFile=testFolder.newFile("testexport.xml");
  URL url=getClass().getResource("/rrdtool/0003l648.rrd");
  RRDatabase rrd=new RRDatabase(url.getFile());
  rrd.toXml(new PrintStream(rrdXmlFile));
  rrd.close();
  String imported=testFolder.getRoot().getAbsolutePath() + "/testexport.rrd";
  RrdDb.getBuilder().setPath(imported).setExternalPath(rrdXmlFile.getCanonicalPath()).doimport();
  try (RrdDb db=RrdDb.getBuilder().setPath(imported).readOnly().setBackendFactory(new RrdNioBackendFactory()).build()){
    Assert.assertNotNull(db.getDatasource("speed"));
    Assert.assertNotNull(db.getDatasource("weight"));
  }
 }
