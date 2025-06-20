@Test public void should_use_class_simple_name_as_description(){
assertEquals(condition.getClass().getSimpleName(),condition.description.value());
}