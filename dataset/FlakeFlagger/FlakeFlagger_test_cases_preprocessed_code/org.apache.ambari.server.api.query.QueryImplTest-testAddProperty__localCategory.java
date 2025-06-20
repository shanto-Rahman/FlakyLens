@Test public void testAddProperty__localCategory(){
assertEquals(2,mapProperties.size());
assertEquals(2,setResultProps.size());
assertTrue(setResultProps.contains("property"));
assertTrue(setResultProps.contains("property2"));
assertEquals(2,setResultProps.size());
assertTrue(setResultProps.contains("property3"));
assertTrue(setResultProps.contains("property4"));
}