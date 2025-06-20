@SuppressWarnings("deprecation") @Test public void optionsAddedButNoHost(){
assertEquals(300,this.context.getBean(Mongo.class).getMongoOptions().getSocketTimeout());
}