@Test public void testInternalThreadLocal() throws InterruptedException {
Integer v=index.getAndIncrement();
System.out.println("thread : " + Thread.currentThread().getName() + " init value : "+ v);
t.start();
Thread.sleep(2000);
}