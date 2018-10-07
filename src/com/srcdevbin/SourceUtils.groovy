package com.srcdevbin


class SourceUtils implements Serializable {
	
	def script
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		def params = resolveModel(cl)
		script.println params.url
		script.sh "echo hello - ${params.url}"
	}
	
	def resolveModel(Closure cl) {
		def model = new SourceModel()
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl.delegate = model
		cl()
		return model
	}
}
