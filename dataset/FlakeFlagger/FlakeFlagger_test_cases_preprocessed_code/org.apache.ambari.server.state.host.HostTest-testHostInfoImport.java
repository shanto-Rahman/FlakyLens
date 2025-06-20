@Test public void testHostInfoImport() throws AmbariException {
Assert.assertEquals(info.getHostName(),host.getHostName());
Assert.assertEquals(info.getFreeMemory(),host.getAvailableMemBytes());
Assert.assertEquals(info.getMemoryTotal(),host.getTotalMemBytes());
Assert.assertEquals(info.getPhysicalProcessorCount(),host.getCpuCount());
Assert.assertEquals(info.getMounts().size(),host.getDisksInfo().size());
Assert.assertEquals(info.getArchitecture(),host.getOsArch());
Assert.assertEquals(info.getOS(),host.getOsType());
}