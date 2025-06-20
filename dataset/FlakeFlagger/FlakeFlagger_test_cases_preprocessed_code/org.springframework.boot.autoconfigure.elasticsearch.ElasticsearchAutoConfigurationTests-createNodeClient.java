@Test public void createNodeClient(){
assertEquals(1,this.context.getBeanNamesForType(Client.class).length);
assertThat(this.context.getBean(Client.class),instanceOf(NodeClient.class));
}