@Test public void testPerson(){
assertEquals(pBaseStr + "[age=33,job=" + pJobStr+ "[title=Manager],name=John Doe,smoker=false]",new ReflectionToStringBuilder(p,new RecursiveToStringStyle()).toString());
}