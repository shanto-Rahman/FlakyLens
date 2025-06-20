@Deployment public void testConcurrentEndOfSameProcess() throws Exception {
assertNotNull(task);
assertFalse(taskCompleter1.isSucceeded());//IT
assertFalse(taskCompleter2.isSucceeded());//IT
taskCompleter1.start();
taskCompleter2.start();
taskCompleter1.join();
taskCompleter2.join();
if (taskCompleter1.isSucceeded()) {//IT
}
if (taskCompleter2.isSucceeded()) {//IT
}
assertEquals("(Only) one thread should have been able to successfully end the process",1,successCount);
}