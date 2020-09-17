apply navigationPlugin 
apply searchPlugin  
apply mapEnginePlugin 
apply NavkitPlugin 
apply clusterPlugin
apply "Denali-MY21-Info.spin"

info {
  region {
    key "current region: value"
	value ""
	descript "Region"
  }
  version {
    key ""
	value ""
	descript "app version"
  }
}

rule{
  "" mustAfter ""
  "" shouldAfter ""
}

chart{
  chatType "pin"
  datax " "
  datay " "
}