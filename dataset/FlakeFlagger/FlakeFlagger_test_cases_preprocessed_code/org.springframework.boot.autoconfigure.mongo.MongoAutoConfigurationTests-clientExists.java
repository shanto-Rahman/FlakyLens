@Test public void clientExists(){
assertEquals(1,this.context.getBeanNamesForType(Mongo.class).length);
}