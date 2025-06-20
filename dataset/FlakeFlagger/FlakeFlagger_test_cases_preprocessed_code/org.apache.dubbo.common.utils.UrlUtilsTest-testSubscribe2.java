@Test public void testSubscribe2(){
assertEquals("dubbo.version=2.0.0&group=test&version=1.0.0",newSubscribe.get("test/dubbo.test.api.HelloService:1.0.0"));
}