package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LogCasesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LogCases.list(params), model:[logCasesInstanceCount: LogCases.count()]
    }

    def show(LogCases logCasesInstance) {
        respond logCasesInstance
    }

    def create() {
        respond new LogCases(params)
    }

    @Transactional
    def save(LogCases logCasesInstance) {
        if (logCasesInstance == null) {
            notFound()
            return
        }

        if (logCasesInstance.hasErrors()) {
            respond logCasesInstance.errors, view:'create'
            return
        }

        logCasesInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logCases.label', default: 'LogCases'), logCasesInstance.id])
                redirect logCasesInstance
            }
            '*' { respond logCasesInstance, [status: CREATED] }
        }
    }

    def edit(LogCases logCasesInstance) {
        respond logCasesInstance
    }

    @Transactional
    def update(LogCases logCasesInstance) {
        if (logCasesInstance == null) {
            notFound()
            return
        }

        if (logCasesInstance.hasErrors()) {
            respond logCasesInstance.errors, view:'edit'
            return
        }

        logCasesInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LogCases.label', default: 'LogCases'), logCasesInstance.id])
                redirect logCasesInstance
            }
            '*'{ respond logCasesInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LogCases logCasesInstance) {

        if (logCasesInstance == null) {
            notFound()
            return
        }

        logCasesInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LogCases.label', default: 'LogCases'), logCasesInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logCases.label', default: 'LogCases'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
