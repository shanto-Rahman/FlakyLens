@Test public void testDeprecatedFilter(){
assertEquals(1,LogUtil.findMessage("The service method org.apache.dubbo.rpc.support.DemoService.echo(String) is DEPRECATED"));
}