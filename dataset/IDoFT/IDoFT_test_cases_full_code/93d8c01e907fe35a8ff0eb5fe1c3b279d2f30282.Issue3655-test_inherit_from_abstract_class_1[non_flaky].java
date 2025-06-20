@Test public void test_inherit_from_abstract_class_1(){
  issue3655_b b=new issue3655_b(null,null,null,null,null,null,null,null,null);
  String result=JSON.toJSONString(b,filter,SerializerFeature.WriteNullStringAsEmpty);
  System.out.println(result);
  Assert.assertEquals(jsonStr,result);
}
