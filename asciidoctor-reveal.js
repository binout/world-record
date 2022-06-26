// Load Asciidoctor.js and the reveal.js converter
const asciidoctor = require('@asciidoctor/core')()
const asciidoctorRevealjs = require('@asciidoctor/reveal.js')
asciidoctorRevealjs.register()

const conferences = ['devoxx', 'breizhcamp']
// Convert the document 'presentation.adoc' using the reveal.js converter
const options = { safe: 'safe', backend: 'revealjs' }
asciidoctor.convertFile('presentation.adoc', {attributes: {conf : 'devoxx'}, ...options})
asciidoctor.convertFile('presentation.adoc', {attributes: {conf : 'breizhcamp'}, 'to_file': 'presentation-bzh.html',  ...options})