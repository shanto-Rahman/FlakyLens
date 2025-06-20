public void testMarshalObj() throws Exception {
  final DataField d1=new DataField(20);
  d1.setData(0,1);
  d1.setData(5,2);
  final DataField d2=new DataField(20);
  d2.setData(0,3);
  d2.setData(8,4);
  Test t=new Test(d1,d2);
  XStream xs=getxStream();
  String xml=xs.toXML(t);
  assertEquals("<?xml version=\"1.0\" ?><test>" + "<d1>1,0,0,0,0,2</d1>" + "<d2>3,0,0,0,0,0,0,0,4</d2>"+ "</test>",xml);
}
