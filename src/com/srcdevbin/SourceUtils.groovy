package com.srcdevbin


class SourceUtils implements Serializable {
	
	def url
	def script
	
	SourceUtils(script) {
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		cl()
		script.sh "echo hello - ${this.url}"
	}
}
