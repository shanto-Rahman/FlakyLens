@Test public void testGetKeyValueHandler() throws Exception {
  Handler kvHandler=dispatcher.getHandler(ContainerProtos.ContainerType.KeyValueContainer);
  Assert.assertTrue("getHandlerForContainerType returned incorrect handler",(kvHandler instanceof KeyValueHandler));
}
