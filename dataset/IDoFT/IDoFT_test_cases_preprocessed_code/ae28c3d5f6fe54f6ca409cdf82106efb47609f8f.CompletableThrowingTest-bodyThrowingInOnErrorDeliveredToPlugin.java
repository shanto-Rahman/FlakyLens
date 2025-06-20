@Test public void bodyThrowingInOnErrorDeliveredToPlugin(){
if (!pluginRef.compareAndSet(null,throwable)) {
}
errorRef.set(throwable);
CompositeException composite=(CompositeException)pluginRef.get();
assertThat(composite.getExceptions()).containsExactly(errorRef.get(),e);
}