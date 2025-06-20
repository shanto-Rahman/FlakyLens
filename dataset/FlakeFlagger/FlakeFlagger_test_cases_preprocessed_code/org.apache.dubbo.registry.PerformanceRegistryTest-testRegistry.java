@Test public void testRegistry(){
if (PerformanceUtils.getProperty("server",null) == null) {
}
new Thread(new Runnable(){
  public void run(){
    for (int j=0; j < runs; j++) {
      registry.register(URL.valueOf("remote://" + NetUtils.getLocalHost() + ":8080/demoService"+ t+ "_"+ j+ "?version=1.0.0&application=demo&dubbo=2.0&interface="+ "org.apache.dubbo.demo.DemoService"+ (base + t)+ "_"+ (base + j)));
    }
  }
}
).start();
}