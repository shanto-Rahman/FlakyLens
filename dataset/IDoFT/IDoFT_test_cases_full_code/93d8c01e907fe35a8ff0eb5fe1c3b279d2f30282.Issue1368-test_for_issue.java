public void test_for_issue() throws Exception {
  ExtendedServletRequestDataBinder binder=new ExtendedServletRequestDataBinder(new Object());
  String json=JSON.toJSONString(binder);
  System.out.println(json);
  Assert.assertTrue(json.indexOf("$ref") >= 0);
}
