@Test public void testReliableSubscriptionsAfterDocumentOwnerChange() throws Throwable {
if (notification.isDelete()) {
}
if (notification.isUpdate()) {
}
if (counter.get() == runningHosts) {
}
}