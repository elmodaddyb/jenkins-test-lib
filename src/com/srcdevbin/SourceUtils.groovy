package com.srcdevbin


class SourceUtils implements Serializable {
	
	def script
	def url
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		resolveModel(cl)
		script.println url
		script.sh "echo hello - ${url}"
	}
	
	def resolveModel(Closure cl) {
		def model = new SourceModel()
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl.delegate = this
		cl()
	}
}
