@Test public void should_create_new_AnyOf_with_passed_Conditions(){
assertEquals(AnyOf.class,created.getClass());
assertEquals(conditions,anyOf.conditions);
}