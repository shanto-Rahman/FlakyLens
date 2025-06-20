@Test public void should_create_new_AnyOf_with_passed_Conditions(){
assertEquals(AnyOf.class,created.getClass());
assertEquals(newArrayList(conditions),anyOf.conditions);
}