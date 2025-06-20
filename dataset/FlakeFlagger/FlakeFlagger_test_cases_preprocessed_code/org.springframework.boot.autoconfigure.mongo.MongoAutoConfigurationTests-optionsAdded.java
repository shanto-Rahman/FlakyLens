@SuppressWarnings("deprecation") @Test public void optionsAdded(){
assertEquals(300,this.context.getBean(Mongo.class).getMongoOptions().getSocketTimeout());
}