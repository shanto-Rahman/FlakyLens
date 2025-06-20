@Test public void testGetHandlerForInvalidContainerType(){
  ContainerProtos.ContainerType invalidContainerType=ContainerProtos.ContainerType.forNumber(2);
  Assert.assertEquals("New ContainerType detected. Not an invalid " + "containerType",invalidContainerType,null);
  Handler dispatcherHandler=dispatcher.getHandler(invalidContainerType);
  Assert.assertEquals("Get Handler for Invalid ContainerType should " + "return null.",dispatcherHandler,null);
}
