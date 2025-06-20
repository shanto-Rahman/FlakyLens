@Test public void getgroups() throws Throwable {
  if (jnr.ffi.Platform.getNativePlatform().isUnix()) {
    String[] groupIdsAsStrings=exec("id -G").split(" ");
    long[] expectedGroupIds=new long[groupIdsAsStrings.length];
    for (int i=0; i < groupIdsAsStrings.length; i++) {
      expectedGroupIds[i]=Long.parseLong(groupIdsAsStrings[i]);
    }
    long[] actualGroupIds=posix.getgroups();
    if (actualGroupIds.length == expectedGroupIds.length - 1) {
      long effectiveGroupId=Long.parseLong(exec("id -g"));
      expectedGroupIds=removeElement(expectedGroupIds,effectiveGroupId);
    }
    Arrays.sort(expectedGroupIds);
    Arrays.sort(actualGroupIds);
    assertArrayEquals(expectedGroupIds,actualGroupIds);
  }
}
