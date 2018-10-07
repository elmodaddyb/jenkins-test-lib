package com.srcdevbin


class SourceUtils implements Serializable {
	
	def script
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		SourceModel model = new SourceModel()
		cl.delegate = model
		cl()
		script.println "The URL --> ${params.url}"
		script.sh "echo hello - ${params.url}"
	}
}
