@Test public void nonSingletonTest2(){
assertNotNull(hello1);
assertNotNull(hello2);
assertNotSame(hello1,hello2);
}