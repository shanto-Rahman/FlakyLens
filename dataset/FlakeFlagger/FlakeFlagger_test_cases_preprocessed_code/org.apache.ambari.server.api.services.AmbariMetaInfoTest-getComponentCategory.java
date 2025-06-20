@Test public void getComponentCategory(){
ComponentInfo componentInfo=metaInfo.getComponentCategory(STACK_NAME_HDP,STACK_VERSION_HDP,SERVICE_NAME_HDFS,SERVICE_COMPONENT_NAME);//RW
assertNotNull(componentInfo);
componentInfo=metaInfo.getComponentCategory(STACK_NAME_HDP,STACK_VERSION_HDP,SERVICE_NAME_HDFS,"DATANODE1");//RW
Assert.assertNotNull(componentInfo);
assertTrue(!componentInfo.isClient());
}