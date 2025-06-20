@Test public void should_set_description(){
condition.as(description);//RW
assertSame(description,condition.description());//RW
}