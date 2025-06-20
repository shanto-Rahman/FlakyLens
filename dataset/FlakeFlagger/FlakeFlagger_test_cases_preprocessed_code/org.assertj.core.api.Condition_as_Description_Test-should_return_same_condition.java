@Test public void should_return_same_condition(){
Condition<Object> returnedCondition=condition.as(description);//RW
assertSame(condition,returnedCondition);
}