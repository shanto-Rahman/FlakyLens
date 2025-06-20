@Test public void test_inherit_from_abstract_class_2(){
  issue3655_c c=new issue3655_c(null,null,null,null,null,null,null,null,null);
  String result=JSON.toJSONString(c,filter,SerializerFeature.WriteNullStringAsEmpty);
  System.out.println(result);
  Assert.assertEquals(jsonStr,result);
}
