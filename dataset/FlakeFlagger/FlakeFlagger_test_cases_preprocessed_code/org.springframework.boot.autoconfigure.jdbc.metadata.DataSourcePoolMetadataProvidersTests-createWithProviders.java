@Test public void createWithProviders(){
assertSame(this.first,provider.getDataSourcePoolMetadata(this.firstDataSource));
assertSame(this.second,provider.getDataSourcePoolMetadata(this.secondDataSource));
assertNull(provider.getDataSourcePoolMetadata(this.unknownDataSource));
}