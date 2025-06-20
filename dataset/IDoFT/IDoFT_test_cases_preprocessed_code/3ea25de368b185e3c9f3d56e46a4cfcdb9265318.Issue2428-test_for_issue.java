public void test_for_issue(){
assertEquals("{\"nestedBean\":{\"myId\":\"test id\"},\"myName\":\"test name\"}",JSON.toJSON(demoBean).toString());
assertEquals("{\"my_name\":\"test name\",\"nested_bean\":{\"my_id\":\"test id\"}}",JSON.toJSON(demoBean,serializeConfig).toString());
}