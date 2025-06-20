@Test public void should_set_description(){
condition.describedAs(description);//RW
assertSame(description,condition.description());//RW
}