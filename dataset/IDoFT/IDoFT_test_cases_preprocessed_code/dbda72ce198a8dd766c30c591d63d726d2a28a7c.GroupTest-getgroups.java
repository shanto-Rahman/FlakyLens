@Test public void getgroups() throws Throwable {
if (jnr.ffi.Platform.getNativePlatform().isUnix()) {
long[] actualGroupIds=posix.getgroups();//RW
if (actualGroupIds.length == expectedGroupIds.length - 1) {
}
assertArrayEquals(expectedGroupIds,actualGroupIds);
}
}