@Test public void responseThrowingInOnCompleteDeliveredToPlugin(){
if (!pluginRef.compareAndSet(null,throwable)) {
}
assertThat(pluginRef.get()).isSameAs(e);
}