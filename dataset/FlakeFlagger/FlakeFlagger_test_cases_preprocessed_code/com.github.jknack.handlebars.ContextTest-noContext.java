@Test(expected=IllegalArgumentException.class) public void noContext(){
assertEquals(context,Context.newContext(context));
}