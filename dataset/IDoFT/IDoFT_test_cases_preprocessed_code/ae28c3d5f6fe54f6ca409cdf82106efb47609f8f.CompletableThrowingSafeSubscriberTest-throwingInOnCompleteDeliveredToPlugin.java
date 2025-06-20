@Test public void throwingInOnCompleteDeliveredToPlugin(){
if (throwable instanceof OnCompletedFailedException) {
if (!pluginRef.compareAndSet(null,throwable)) {
}
}
assertThat(pluginRef.get().getCause()).isSameAs(e);
}