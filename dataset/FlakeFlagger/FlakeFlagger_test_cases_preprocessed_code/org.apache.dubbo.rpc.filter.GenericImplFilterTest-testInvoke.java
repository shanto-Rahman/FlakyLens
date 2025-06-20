@Test public void testInvoke() throws Exception {
Assert.assertEquals(Person.class,result.getValue().getClass());
Assert.assertEquals(10,((Person)result.getValue()).getAge());
}