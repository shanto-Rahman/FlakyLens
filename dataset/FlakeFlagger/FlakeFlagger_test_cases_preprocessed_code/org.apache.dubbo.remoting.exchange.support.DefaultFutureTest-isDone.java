@Test public void isDone(){
Assert.assertTrue("init future is finished!",!future.isDone());
Assert.assertTrue("cancel a future failed!",future.isDone());
}