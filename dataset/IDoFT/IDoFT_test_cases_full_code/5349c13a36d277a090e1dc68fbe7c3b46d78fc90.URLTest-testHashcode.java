@Test public void testHashcode(){
  URL url1=URL.valueOf("consumer://30.225.20.150/org.apache.dubbo.rpc.service.GenericService?application=" + "dubbo-demo-api-consumer&category=consumers&check=false&dubbo=2.0.2&generic=true&interface=" + "org.apache.dubbo.demo.DemoService&pid=7375&side=consumer&sticky=false&timestamp=1599556506417");
  URL url2=URL.valueOf("consumer://30.225.20.150/org.apache.dubbo.rpc.service.GenericService?application=" + "dubbo-demo-api-consumer&category=consumers&check=false&dubbo=2.0.2&generic=true&interface=" + "org.apache.dubbo.demo.DemoService&pid=7375&side=consumer&sticky=false&timestamp=2299556506417");
  assertEquals(url1.hashCode(),url2.hashCode());
  URL url3=URL.valueOf("consumer://30.225.20.150/org.apache.dubbo.rpc.service.GenericService?application=" + "dubbo-demo-api-consumer&category=consumers&check=false&dubbo=2.0.2&interface=" + "org.apache.dubbo.demo.DemoService&pid=7375&side=consumer&sticky=false&timestamp=2299556506417");
  assertNotEquals(url2.hashCode(),url3.hashCode());
  URL url4=URL.valueOf("consumer://30.225.20.150/org.apache.dubbo.rpc.service.GenericService?application=" + "dubbo-demo-api-consumer&category=consumers&check=true&dubbo=2.0.2&interface=" + "org.apache.dubbo.demo.DemoService&pid=7375&side=consumer&sticky=false&timestamp=2299556506417");
  assertNotEquals(url3.hashCode(),url4.hashCode());
}
