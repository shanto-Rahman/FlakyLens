public void testMarshalObj3(){
  final DataField d1=new DataField(20);
  for (int i=0; i < 11; i++)   d1.setData(i,2);
  final DataField d2=new DataField(20);
  for (int j=0; j < 11; j++)   for (int i=0; i < 11; i++)   d2.setData(i + j * 11,j + 1);
  XStream xs=getxStream();
  String xml=xs.toXML(new Test(d1,d2));
  assertEquals("<?xml version=\"1.0\" ?><test>" + "<d1>11*2</d1>" + "<d2>11*1,11*2,11*3,11*4,11*5,11*6,11*7,11*8,11*9,11*a,11*b</d2>"+ "</test>",xml);
}
