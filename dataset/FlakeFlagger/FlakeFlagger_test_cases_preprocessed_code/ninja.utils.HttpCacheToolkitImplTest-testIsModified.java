@Test public void testIsModified(){
assertFalse(httpCacheToolkit.isModified(Optional.of("etag_xyz"),Optional.of(0L),context));
assertTrue(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(0L),context));
assertTrue(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(0L),context));
assertTrue(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(1000L),context));
assertFalse(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(0L),context));
assertFalse(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(0L),context));
assertTrue(httpCacheToolkit.isModified(Optional.of("etag_xyz_modified"),Optional.of(0L),context));
}