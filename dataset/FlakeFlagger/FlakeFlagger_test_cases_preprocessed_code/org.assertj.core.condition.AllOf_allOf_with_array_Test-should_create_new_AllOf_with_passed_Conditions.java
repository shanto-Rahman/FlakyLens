@Test public void should_create_new_AllOf_with_passed_Conditions(){
assertEquals(AllOf.class,created.getClass());
assertEquals(newArrayList(conditions),allOf.conditions);
}