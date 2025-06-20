@Test public void testGetAllCommandClass() throws Exception {
assertThat(classes,containsInAnyOrder(GreetingCommand.class,Help.class,Ls.class,Offline.class,Online.class,Quit.class));
}