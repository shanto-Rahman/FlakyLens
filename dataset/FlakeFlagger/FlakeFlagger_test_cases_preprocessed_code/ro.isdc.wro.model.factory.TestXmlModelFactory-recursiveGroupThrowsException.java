@Test(expected=RecursiveGroupDefinitionException.class) public void recursiveGroupThrowsException(){
return Thread.currentThread().getContextClassLoader().getResourceAsStream("recursive.xml");
}