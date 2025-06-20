@Test public void testRegister(){
assertThat(registered.contains(serviceUrl),is(true));
assertThat(registered.size(),is(1));
}