/** 
 * It print like this: thread number in current pool：1,  task number in task queue：0 executor size: 1 thread number in current pool：2,  task number in task queue：0 executor size: 2 thread number in current pool：3,  task number in task queue：0 executor size: 3 thread number in current pool：4,  task number in task queue：0 executor size: 4 thread number in current pool：5,  task number in task queue：0 executor size: 5 thread number in current pool：6,  task number in task queue：0 executor size: 6 thread number in current pool：7,  task number in task queue：0 executor size: 7 thread number in current pool：8,  task number in task queue：0 executor size: 8 thread number in current pool：9,  task number in task queue：0 executor size: 9 thread number in current pool：10,  task number in task queue：0 executor size: 10 thread number in current pool：10,  task number in task queue：4 executor size: 10 thread number in current pool：10,  task number in task queue：3 executor size: 10 thread number in current pool：10,  task number in task queue：2 executor size: 10 thread number in current pool：10,  task number in task queue：1 executor size: 10 thread number in current pool：10,  task number in task queue：0 executor size: 10 <p> We can see , when the core threads are in busy, the thread pool create thread (but thread nums always less than max) instead of put task into queue.
 */
@Test public void testEagerThreadPool() throws Exception {
Thread.sleep(50);
Thread.sleep(1000);
Thread.sleep(5000);
Assert.assertTrue("more than cores threads alive!",executor.getPoolSize() == cores);
}