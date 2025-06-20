@Test public void testBindingWithTwoBeans(){
assertEquals(1,this.context.getBeanNamesForType(TestProperties.class).length);
assertEquals(1,this.context.getBeanNamesForType(MoreProperties.class).length);
}