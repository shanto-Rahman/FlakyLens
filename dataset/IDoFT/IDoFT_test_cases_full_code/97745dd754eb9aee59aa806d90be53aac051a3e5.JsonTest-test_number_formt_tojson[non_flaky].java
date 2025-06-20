@Test public void test_number_formt_tojson(){
  NumBean num=new NumBean();
  num.setNum1(1);
  String a="{\n" + "   \"num1\": \"01.00\",\n" + "   \"num2\": \"02.00\"\n"+ "}";
  String str=Json.toJson(num);
  assertJsonEqualsNonStrict(a,str);
  System.out.println(str);
}
