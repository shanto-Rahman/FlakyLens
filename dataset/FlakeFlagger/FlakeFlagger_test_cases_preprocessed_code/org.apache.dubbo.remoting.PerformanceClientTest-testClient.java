@Test @SuppressWarnings("unchecked") public void testClient() throws Throwable {
if (PerformanceUtils.getProperty("server",null) == null) {
}
new Thread(new Runnable(){
  public void run(){
    try {
      AtomicInteger index=new AtomicInteger();
      long init=System.currentTimeMillis();
      for (int i=0; i < runs; i++) {
        try {
          count.incrementAndGet();
          ExchangeClient client=exchangeClients[index.getAndIncrement() % connections];
          long start=System.currentTimeMillis();
          String result=(String)client.request(data).get();
          long end=System.currentTimeMillis();
          if (!data.equals(result)) {
            throw new IllegalStateException("Invalid result " + result);
          }
          time.addAndGet(end - start);
        }
 catch (        Exception e) {
          error.incrementAndGet();
          e.printStackTrace();
          if ("exit".equals(onerror)) {
            System.exit(-1);
          }
 else           if ("break".equals(onerror)) {
            break;
          }
 else           if ("sleep".equals(onerror)) {
            try {
              Thread.sleep(30000);
            }
 catch (            InterruptedException e1) {
            }
          }
        }
      }
      all.addAndGet(System.currentTimeMillis() - init);
    }
  finally {
      latch.countDown();
    }
  }
}
).start();
count.incrementAndGet();
ExchangeClient client=exchangeClients[index.getAndIncrement() % connections];
if (!data.equals(result)) {
}
time.addAndGet(end - start);
error.incrementAndGet();
if ("exit".equals(onerror)) {
if ("break".equals(onerror)) {
if ("sleep".equals(onerror)) {
Thread.sleep(30000);
}
}
}
all.addAndGet(System.currentTimeMillis() - init);
latch.countDown();
new Thread(new Runnable(){
  public void run(){
    try {
      SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
      long lastCount=count.get();
      long sleepTime=2000;
      long elapsd=sleepTime / 1000;
      boolean bfirst=true;
      while (latch.getCount() > 0) {
        long c=count.get() - lastCount;
        if (!bfirst)         System.out.println("[" + dateFormat.format(new Date()) + "] count: "+ count.get()+ ", error: "+ error.get()+ ",tps:"+ (c / elapsd));
        bfirst=false;
        lastCount=count.get();
        Thread.sleep(sleepTime);
      }
    }
 catch (    Exception e) {
      e.printStackTrace();
    }
  }
}
).start();
long lastCount=count.get();
while (latch.getCount() > 0) {
  long c=count.get() - lastCount;
  if (!bfirst)   System.out.println("[" + dateFormat.format(new Date()) + "] count: "+ count.get()+ ", error: "+ error.get()+ ",tps:"+ (c / elapsd));
  bfirst=false;
  lastCount=count.get();
  Thread.sleep(sleepTime);
}
long c=count.get() - lastCount;
if (!bfirst) System.out.println("[" + dateFormat.format(new Date()) + "] count: "+ count.get()+ ", error: "+ error.get()+ ",tps:"+ (c / elapsd));
System.out.println("[" + dateFormat.format(new Date()) + "] count: "+ count.get()+ ", error: "+ error.get()+ ",tps:"+ (c / elapsd));
lastCount=count.get();
Thread.sleep(sleepTime);
latch.await();
if (client.isConnected()) {
}
long total=count.get();
long failed=error.get();
long elapsed=time.get();
long allElapsed=all.get();
if (elapsed > 0) {
}
}