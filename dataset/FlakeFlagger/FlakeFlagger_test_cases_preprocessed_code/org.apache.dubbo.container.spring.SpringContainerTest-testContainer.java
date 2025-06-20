@Test public void testContainer(){
Assert.assertEquals(SpringContainer.class,container.context.getBean("container").getClass());
}