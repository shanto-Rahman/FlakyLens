@Test public void testAddProperty__localSubCategory(){
assertEquals(1,mapProperties.size());
assertEquals(2,setResultProps.size());
assertTrue(setResultProps.contains("property3"));
assertTrue(setResultProps.contains("property4"));
}