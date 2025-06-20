@Test public void throwingInOnCompleteDeliveredToPlugin(){
if (!pluginRef.compareAndSet(null,throwable)) {
}
assertThat(pluginRef.get()).isSameAs(e);
}