@Test public void testAddProperty__localCategorySubPropsOnly(){
assertEquals(2,mapProperties.size());
assertTrue(mapProperties.get("category").isEmpty());
assertEquals(2,setResultProps.size());
assertTrue(setResultProps.contains("property3"));
assertTrue(setResultProps.contains("property4"));
}