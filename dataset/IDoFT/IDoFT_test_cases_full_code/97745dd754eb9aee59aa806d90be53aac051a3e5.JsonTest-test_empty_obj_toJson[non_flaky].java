@Test public void test_empty_obj_toJson(){
  String j=Json.toJson(new Person(),JsonFormat.compact().setQuoteName(true));
  assertJsonEqualsNonStrict("{\"age\":0,\"num\":0}",j);
}
