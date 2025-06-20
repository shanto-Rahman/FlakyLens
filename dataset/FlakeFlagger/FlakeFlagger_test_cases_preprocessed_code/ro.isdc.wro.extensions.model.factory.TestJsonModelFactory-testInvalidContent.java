@Test(expected=WroRuntimeException.class) public void testInvalidContent(){
Assert.assertNull(factory.create());
}