public void test_for_issue(){
assertEquals("{\"myName\":\"test name\",\"nestedBean\":{\"myId\":\"test id\"}}",text);
assertEquals("{\"my_name\":\"test name\",\"nested_bean\":{\"my_id\":\"test id\"}}",text);
}