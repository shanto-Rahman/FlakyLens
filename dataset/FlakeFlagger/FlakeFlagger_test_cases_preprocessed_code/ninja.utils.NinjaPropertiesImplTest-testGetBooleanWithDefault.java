@Test public void testGetBooleanWithDefault(){
assertEquals(Boolean.valueOf(true),ninjaProperties.getBooleanWithDefault("non_existsing_property_to_check_defaults",true));
assertEquals(Boolean.valueOf(true),ninjaProperties.getBooleanWithDefault("booleanTestTrue",false));
}