package com.srcdevbin


class SourceUtils implements Serializable {
	
	def script
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		def params = resolveParams(cl)
		script.println params.url
		script.sh "echo hello - ${params.url}"
	}
	
	def resolveParams(Closure cl) {
		def params = [:]
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl.delegate = params
		cl()
		return params
	}
}
