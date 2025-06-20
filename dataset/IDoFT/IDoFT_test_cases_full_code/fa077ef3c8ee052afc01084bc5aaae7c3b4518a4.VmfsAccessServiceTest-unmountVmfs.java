@Test public void unmountVmfs() throws Exception {
  Map<String,Object> params=new HashMap<>();
  String dataStoreObjectId="qq";
  String hostId="13213";
  String volumeId="41513";
  List<String> list=new ArrayList();
  list.add(dataStoreObjectId);
  params.put("hostId",hostId);
  List<String> volumeIds=new ArrayList();
  volumeIds.add(volumeId);
  params.put(DmeConstants.VOLUMEIDS,volumeIds);
  params.put(DmeConstants.DATASTOREOBJECTIDS,list);
  unmountVmfBefore();
  vmfsAccessService.unmountVmfs(params);
}
