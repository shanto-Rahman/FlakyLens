@Test public void testDuplicateArrayList(){
  A a=new A();
  a.list1=new ArrayList<String>();
  a.list1.add("aaa");
  a.list2=new ArrayList<String>();
  a.list2.add("aaa");
  String json=Json.toJson(a,JsonFormat.compact().setQuoteName(false));
  String exp="{list1:[\"aaa\"],list2:[\"aaa\"]}";
  assertJsonEqualsNonStrict(exp,json);
}
