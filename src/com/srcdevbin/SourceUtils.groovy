package com.srcdevbin


class SourceUtils implements Serializable {
	
	def script
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		def params = [:]
		cl.delegate = params
		cl()
		script.println params.url
		script.sh "echo hello - ${params.url}"
	}
}
