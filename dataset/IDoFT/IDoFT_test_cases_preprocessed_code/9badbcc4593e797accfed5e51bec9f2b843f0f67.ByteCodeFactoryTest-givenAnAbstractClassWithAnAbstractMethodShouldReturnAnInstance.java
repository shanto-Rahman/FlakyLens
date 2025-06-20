@Test public void givenAnAbstractClassWithAnAbstractMethodShouldReturnAnInstance(){
Assert.assertEquals("Should have 1 constructor and 1 abstract method",2,pojoClass.getPojoMethods().size());
assertNotNull(subclass);
}