public void testMarshalObj2(){
  final DataField d1=new DataField(20);
  d1.setData(5,2);
  final DataField d2=new DataField(20);
  d2.setData(8,4);
  XStream xs=getxStream();
  String xml=xs.toXML(new Test(d1,d2));
  assertEquals("<?xml version=\"1.0\" ?><test>" + "<d1>5*0,2</d1>" + "<d2>8*0,4</d2>"+ "</test>",xml);
}
