@Test public void testClient() throws Throwable {
if (PerformanceUtils.getProperty("server",null) == null) {
}
new Thread(new Runnable(){
  public void run(){
    for (int i=0; i < runs; i++) {
      ExchangeClient client=null;
      try {
        client=Exchangers.connect(url);
        int c=count.incrementAndGet();
        if (c % 100 == 0) {
          System.out.println("count: " + count.get() + ", error: "+ error.get());
        }
      }
 catch (      Exception e) {
        error.incrementAndGet();
        e.printStackTrace();
        System.out.println("count: " + count.get() + ", error: "+ error.get());
        if ("exit".equals(onerror)) {
          System.exit(-1);
        }
 else         if ("break".equals(onerror)) {
          break;
        }
 else         if ("sleep".equals(onerror)) {
          try {
            Thread.sleep(30000);
          }
 catch (          InterruptedException e1) {
          }
        }
      }
 finally {
        if (client != null) {
          client.close();
        }
      }
    }
  }
}
).start();
int c=count.incrementAndGet();
if (c % 100 == 0) {
System.out.println("count: " + count.get() + ", error: "+ error.get());
}
error.incrementAndGet();
System.out.println("count: " + count.get() + ", error: "+ error.get());
if ("exit".equals(onerror)) {
if ("break".equals(onerror)) {
if ("sleep".equals(onerror)) {
Thread.sleep(30000);
}
}
}
if (client != null) {
}
}