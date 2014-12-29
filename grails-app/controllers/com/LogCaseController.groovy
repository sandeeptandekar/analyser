package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LogCaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LogCase.list(params), model:[logCaseInstanceCount: LogCase.count()]
    }

    def show(LogCase logCaseInstance) {
        respond logCaseInstance
    }

    def create() {
        respond new LogCase(params)
    }

    @Transactional
    def save(LogCase logCaseInstance) {
        if (logCaseInstance == null) {
            notFound()
            return
        }

        if (logCaseInstance.hasErrors()) {
            respond logCaseInstance.errors, view:'create'
            return
        }

        logCaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect logCaseInstance
            }
            '*' { respond logCaseInstance, [status: CREATED] }
        }
    }

    def edit(LogCase logCaseInstance) {
        respond logCaseInstance
    }

    @Transactional
    def update(LogCase logCaseInstance) {
        if (logCaseInstance == null) {
            notFound()
            return
        }

        if (logCaseInstance.hasErrors()) {
            respond logCaseInstance.errors, view:'edit'
            return
        }

        logCaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LogCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect logCaseInstance
            }
            '*'{ respond logCaseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LogCase logCaseInstance) {

        if (logCaseInstance == null) {
            notFound()
            return
        }

        logCaseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LogCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logCase.label', default: 'LogCase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
