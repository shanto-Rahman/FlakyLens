@Test public void testPerson(){
assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false,job=" + pJobStr+ "[title=Manager]]",new ReflectionToStringBuilder(p,new RecursiveToStringStyle()).toString());
}