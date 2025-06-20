@Test public void responseThrowingInOnSuccessDeliveredToPlugin(){
if (!pluginRef.compareAndSet(null,throwable)) {
}
assertThat(pluginRef.get()).isSameAs(e);
}