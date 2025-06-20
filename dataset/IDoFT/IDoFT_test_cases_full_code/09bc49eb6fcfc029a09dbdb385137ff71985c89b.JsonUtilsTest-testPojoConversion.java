@Test public void testPojoConversion(){
  ComplexPojo pojo=new ComplexPojo();
  pojo.setFoo("testFoo");
  pojo.setBar(1);
  ComplexPojo p1=new ComplexPojo();
  p1.setFoo("p1");
  ComplexPojo p2=new ComplexPojo();
  p2.setFoo("p2");
  pojo.setBan(Arrays.asList(p1,p2));
  String s=JsonUtils.toJson(pojo);
  String expected="{\"bar\":1,\"foo\":\"testFoo\",\"baz\":null,\"ban\":[{\"bar\":0,\"foo\":\"p1\",\"baz\":null,\"ban\":null},{\"bar\":0,\"foo\":\"p2\",\"baz\":null,\"ban\":null}]}";
  assertEquals(s,expected);
  ComplexPojo temp=(ComplexPojo)JsonUtils.fromJson(s,ComplexPojo.class.getName());
  assertEquals(temp.getFoo(),"testFoo");
  assertEquals(2,temp.getBan().size());
  temp=JsonUtils.fromJson(s,ComplexPojo.class);
  assertEquals(temp.getFoo(),"testFoo");
  assertEquals(2,temp.getBan().size());
  s=XmlUtils.toXml(pojo);
  assertEquals(s,"<root><bar>1</bar><foo>testFoo</foo><baz/><ban><bar>0</bar><foo>p1</foo><baz/><ban/></ban><ban><bar>0</bar><foo>p2</foo><baz/><ban/></ban></root>");
}
