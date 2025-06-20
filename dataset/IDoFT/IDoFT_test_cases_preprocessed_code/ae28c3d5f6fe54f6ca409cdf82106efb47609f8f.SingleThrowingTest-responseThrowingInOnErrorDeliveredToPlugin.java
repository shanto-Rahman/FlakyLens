@Test public void responseThrowingInOnErrorDeliveredToPlugin(){
if (!pluginRef.compareAndSet(null,throwable)) {
}
if (!errorRef.compareAndSet(null,throwable)) {
}
CompositeException composite=(CompositeException)pluginRef.get();
assertThat(composite.getExceptions()).containsExactly(errorRef.get(),e);
}